package com.example.inventoryservice.controller;


import com.example.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class InventoryController {

    private  InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/place-order")
    public void processCandyOrder(){
        System.out.println(LocalTime.now() + " Receive order ");
        inventoryService.processCandyOrder();
    }
}
