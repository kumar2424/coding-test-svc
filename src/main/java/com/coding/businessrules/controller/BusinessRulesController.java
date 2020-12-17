package com.coding.businessrules.controller;

import com.coding.businessrules.service.ProcessOrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/businessrules")
public class BusinessRulesController {

    @Autowired
    ProcessOrderServiceI processOrderServiceI;
    @RequestMapping(value = "/payment", method = RequestMethod.PUT)
    public String processOrder(@RequestParam("productType") String productType) {
            String orderStatus = processOrderServiceI.processBusinessOrder(productType);
            return orderStatus;
    }
}
