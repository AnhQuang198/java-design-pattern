package com.example.demodesignpattern.services.databaseManager.factories;

import com.example.demodesignpattern.services.databaseManager.account.AccountFactory;
import com.example.demodesignpattern.services.databaseManager.shop.ShopFactory;
import com.example.demodesignpattern.services.databaseManager.shop.ShopMongoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoFactory extends DatabaseAbstractFactory {
    @Autowired private ShopMongoData shopMongoData;

    @Override
    public ShopFactory shopData() {
        return shopMongoData;
    }

    @Override
    public AccountFactory accountData() {
        return null;
    }
}
