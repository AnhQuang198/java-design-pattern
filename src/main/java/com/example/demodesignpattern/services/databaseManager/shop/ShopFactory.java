package com.example.demodesignpattern.services.databaseManager.shop;

import com.example.demodesignpattern.dtos.ShopDTO;

public interface ShopFactory {
    ShopDTO getData(Integer shopId) throws Exception;

    void createShop() throws Exception;
}
