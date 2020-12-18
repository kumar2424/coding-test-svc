package com.coding.businessrules.service.impl;

import com.coding.businessrules.service.PhysicalProductServiceI;
import org.springframework.stereotype.Service;

@Service
public class PhysicalProductServiceImpl implements PhysicalProductServiceI {

    @Override
    public String generatePackingSlip(String product) {
        return "Generated Packing slip for Shipping";
    }
}
