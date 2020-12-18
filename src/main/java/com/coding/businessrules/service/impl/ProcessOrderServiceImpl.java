package com.coding.businessrules.service.impl;

import com.coding.businessrules.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessOrderServiceImpl implements ProcessOrderServiceI {

    @Autowired
    PhysicalProductServiceI physicalProductServiceI;

    @Autowired
    BookServiceI bookServiceI;

    @Autowired
    MembershipServiceI membershipServiceI;

    @Autowired
    UpgradeMembershipServiceI upgradeMembershipServiceI;

    @Autowired
    VideoServiceI videoServiceI;

    public ProcessOrderServiceImpl(PhysicalProductServiceI physicalProductServiceI,
                                   BookServiceI bookServiceI,
                                   MembershipServiceI membershipServiceI,
                                   UpgradeMembershipServiceI upgradeMembershipServiceI,
                                   VideoServiceI videoServiceI) {
        this.physicalProductServiceI = physicalProductServiceI;
        this.bookServiceI = bookServiceI;
        this.membershipServiceI = membershipServiceI;
        this.upgradeMembershipServiceI = upgradeMembershipServiceI;
        this.videoServiceI = videoServiceI;
    }

    @Override
    public String processBusinessOrder(String product) {
        String response = null;
        switch (product) {
            case "physical product":
                response = physicalProductServiceI.generatePackingSlip(product);
                break;
            case "book":
                response = bookServiceI.generatePackingSlip(product);
                break;
            case "membership":
                response = membershipServiceI.generatePackingSlip(product);
                break;
            case "upgrade membership":
                response = upgradeMembershipServiceI.generatePackingSlip(product);
                break;
            case "video":
                response = videoServiceI.generatePackingSlip(product);
                break;
            default:
                response = "Enter a valid product";
        }
        return response;
    }
}
