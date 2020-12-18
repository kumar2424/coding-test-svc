package com.coding.businessrules.service.impl;

import com.coding.businessrules.service.MembershipServiceI;
import org.springframework.stereotype.Service;

@Service
public class MembershipServiceImpl implements MembershipServiceI {

    @Override
    public String generatePackingSlip(String product) {
        return "Activate membership";
    }
}
