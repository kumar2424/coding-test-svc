package com.coding.businessrules.service.impl;

import com.coding.businessrules.service.ProcessOrderServiceI;
import org.springframework.stereotype.Service;

@Service
public class ProcessOrderServiceImpl implements ProcessOrderServiceI {

    @Override
    public String processBusinessOrder(String product) {
        return "TestMesage";
    }
}
