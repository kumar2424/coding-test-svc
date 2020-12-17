package com.coding.businessrules.controller;

import com.coding.businessrules.service.ProcessOrderServiceI;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.platform.runner.JUnitPlatform;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class BusinessRulesControllerTest {

    @InjectMocks
    BusinessRulesController businessRulesController;

    @Mock
    ProcessOrderServiceI processOrderServiceI;

    @Test
    public void testProcessMessage()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        String product = "abc";
        when(processOrderServiceI.processBusinessOrder(product)).thenReturn("abc invoiced");

        String response = businessRulesController.processOrder(product);
        assertThat(response.equals("abc invoiced"));

    }
}
