package com.example.inventoryservice.service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class InventoryService {
    int amountOfCandy;

    public InventoryService() {
        this.amountOfCandy = 50;
    }

    public boolean processCandyOrder()  {
        if (getAmountOfCandy() > 0){
            setAmountOfCandy(getAmountOfCandy()-1);
            System.out.println(LocalTime.now() + " Current Amount of Candy In Stock : " + getAmountOfCandy());
            return true;
        }
        else{
            System.out.println(LocalTime.now() + " No more candy in stock");
        }
        return false;
    }

    public int getAmountOfCandy() {
        return amountOfCandy;
    }

    public void setAmountOfCandy(int amountOfCandy) {
        this.amountOfCandy = amountOfCandy;
    }
}
