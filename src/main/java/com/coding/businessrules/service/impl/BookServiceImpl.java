package com.coding.businessrules.service.impl;

import com.coding.businessrules.service.BookServiceI;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookServiceI {

    @Override
    public String generatePackingSlip(String product) {
        return "Created a duplicate Packing slip for Royalty department";
    }
}
