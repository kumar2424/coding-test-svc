package com.coding.businessrules.service.impl;

import com.coding.businessrules.service.VideoServiceI;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoServiceI {

    @Override
    public String generatePackingSlip(String product) {
        return "Added free First aid video to the packing slip";
    }
}
