package com.example.demodesignpattern.services;

import com.example.demodesignpattern.dtos.ShopDTO;
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
        ShopDTO shop = null;
        try {
            shop = databaseManager.getFactory(DatabaseManager.Type.MONGODB).shopData().getData(shopId);
            if (Objects.isNull(shop)) {
                shop = databaseManager.getFactory(DatabaseManager.Type.POSTGRES).shopData().getData(shopId);
            }
        } catch (Exception e) {
            log.error("Shop error: " + e);
        }
        return ResponseEntity.ok(shop);
    }

    public ResponseEntity<?> createShop() {
        try {
//            databaseManager.getFactory(DatabaseManager.Type.MONGODB).shopData().createShop();
            databaseManager.getFactory(DatabaseManager.Type.POSTGRES).shopData().createShop();
        } catch (Exception e) {
            log.error("Shop create error: " + e);
        }
        return (ResponseEntity<?>) ResponseEntity.accepted();
    }
}
