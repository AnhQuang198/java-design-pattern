package com.example.demodesignpattern.services.databaseManager.factories;

import com.example.demodesignpattern.services.databaseManager.account.AccountFactory;
import com.example.demodesignpattern.services.databaseManager.shop.ShopFactory;

/**
 * Abstract Factory design pattern
 */
public abstract class DatabaseAbstractFactory {
    public abstract ShopFactory shopData();

    public abstract AccountFactory accountData();
}
