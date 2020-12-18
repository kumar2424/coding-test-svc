package com.coding.businessrules.service.impl;

import com.coding.businessrules.service.UpgradeMembershipServiceI;
import org.springframework.stereotype.Service;

@Service
public class UpgradeMembershipServiceImpl implements UpgradeMembershipServiceI {

    @Override
    public String generatePackingSlip(String product) {
        return "Upgraded membership";
    }
}
