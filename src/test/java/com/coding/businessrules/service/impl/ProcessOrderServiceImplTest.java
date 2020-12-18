package com.coding.businessrules.service.impl;

import com.coding.businessrules.service.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest(classes = {
        ProcessOrderServiceI.class,
        VideoServiceImpl.class,
        BookServiceImpl.class,
        MembershipServiceImpl.class,
        UpgradeMembershipServiceImpl.class
})

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@EnableConfigurationProperties
@RunWith(MockitoJUnitRunner.class)
class ProcessOrderServiceImplTest {

    private ProcessOrderServiceImpl processOrderServiceImpl;

    @MockBean
    PhysicalProductServiceI physicalProductServiceI;

    @Autowired
    BookServiceI bookServiceI;

    @Autowired
    MembershipServiceI membershipServiceI;

    @Autowired
    UpgradeMembershipServiceI upgradeMembershipServiceI;

    @Autowired
    VideoServiceI videoServiceI;

    @BeforeEach
    void setUp() throws IOException {

        processOrderServiceImpl = new ProcessOrderServiceImpl(physicalProductServiceI, bookServiceI,
                membershipServiceI,upgradeMembershipServiceI, videoServiceI);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void processVideoProduct() {

        String product = "video";
        String response = processOrderServiceImpl.processBusinessOrder(product);
        assertThat(response.equals("Added free First aid video to the packing slip"));

    }

    @Test
    public void processBookProduct() {

        String product = "book";

        String response = processOrderServiceImpl.processBusinessOrder(product);
        assertThat(response.equals("Created a duplicate Packing slip for Royalty department"));
    }

    @Test
    public void processMembershipProduct() {

        String product = "membership";

        String response = processOrderServiceImpl.processBusinessOrder(product);
        assertThat(response.equals("Activate membership"));
    }

    @Test
    public void processUpgradeMembershipProduct() {

        String product = "upgrade membership";

        String response = processOrderServiceImpl.processBusinessOrder(product);
        assertThat(response.equals("Upgraded membership"));
    }

    @Test
    public void errorOutForWrongProduct() {

        String product = "Invalid product";

        String response = processOrderServiceImpl.processBusinessOrder(product);
        assertThat(response.equals("Enter a valid product"));
    }

}