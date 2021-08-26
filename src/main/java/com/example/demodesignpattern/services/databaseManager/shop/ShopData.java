package com.example.demodesignpattern.services.databaseManager.shop;

import com.example.demodesignpattern.dtos.ShopDTO;
import com.example.demodesignpattern.services.databaseManager.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ShopData {
    @Autowired
    private DatabaseManager databaseManager;

    public ShopDTO getShopInfo(int shopId) {
        ShopDTO shop;
        shop = databaseManager.getFactory(DatabaseManager.Type.MONGODB).shopData().getData(shopId);
        if (Objects.isNull(shop)) {
            shop = databaseManager.getFactory(DatabaseManager.Type.POSTGRES).shopData().getData(shopId);
            createShop(shop);
        }
        return shop;
    }

    public void createShop(ShopDTO shopDTO) {
        databaseManager.getFactory(DatabaseManager.Type.MONGODB).shopData().createShop(shopDTO);
    }
}
