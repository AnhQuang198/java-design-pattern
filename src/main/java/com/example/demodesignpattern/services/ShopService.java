package com.example.demodesignpattern.services;

import com.example.demodesignpattern.dtos.ShopDTO;
import com.example.demodesignpattern.exceptions.BadRequestException;
import com.example.demodesignpattern.exceptions.ResourceNotFoundException;
import com.example.demodesignpattern.services.databaseManager.DatabaseManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Log4j2
public class ShopService {
    @Autowired
    private DatabaseManager databaseManager;

    public ResponseEntity<?> getShopInfo(int shopId) {
        ShopDTO shop;
        shop = databaseManager.getFactory(DatabaseManager.Type.MONGODB).shopData().getData(shopId);
        if (Objects.isNull(shop)) {
            shop = databaseManager.getFactory(DatabaseManager.Type.POSTGRES).shopData().getData(shopId);
        }
        return ResponseEntity.ok(shop);
    }

    public ResponseEntity<?> createShop() {
//            databaseManager.getFactory(DatabaseManager.Type.MONGODB).shopData().createShop();
        databaseManager.getFactory(DatabaseManager.Type.POSTGRES).shopData().createShop();
        return ResponseEntity.ok("Created");
    }
}
