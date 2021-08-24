package com.example.demodesignpattern.services.databaseManager.factories;

import com.example.demodesignpattern.services.databaseManager.account.AccountFactory;
import com.example.demodesignpattern.services.databaseManager.shop.ShopFactory;
import com.example.demodesignpattern.services.databaseManager.shop.ShopPostgresData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresFactory extends DatabaseAbstractFactory{
    @Autowired private ShopPostgresData shopPostgresData;

    @Override
    public ShopFactory shopData() {
        return shopPostgresData;
    }

    @Override
    public AccountFactory accountData() {
        return null;
    }
}
