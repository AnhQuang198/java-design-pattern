package com.example.demodesignpattern.services;

import com.example.demodesignpattern.dtos.ShopDTO;
import com.example.demodesignpattern.services.databaseManager.shop.ShopData;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class ShopService {
    @Autowired
    private ShopData shopData;

    public ResponseEntity<?> getShopInfo(int shopId) {
        ShopDTO shop = shopData.getShopInfo(shopId);
        return ResponseEntity.ok(shop);
    }

    public ResponseEntity<?> createShop(ShopDTO shopDTO) {
        shopData.createShop(shopDTO);
        return ResponseEntity.ok("Created");
    }
}
