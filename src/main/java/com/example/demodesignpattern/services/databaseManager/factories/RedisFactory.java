package com.example.demodesignpattern.services.databaseManager.factories;

import com.example.demodesignpattern.services.databaseManager.account.AccountFactory;
import com.example.demodesignpattern.services.databaseManager.shop.ShopFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisFactory extends DatabaseAbstractFactory{
    @Override
    public ShopFactory shopData() {
        return null;
    }

    @Override
    public AccountFactory accountData() {
        return null;
    }
}
