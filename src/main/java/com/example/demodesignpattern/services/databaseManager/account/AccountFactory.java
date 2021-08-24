package com.example.demodesignpattern.services.databaseManager.account;

import com.example.demodesignpattern.dtos.AccountDTO;

public interface AccountFactory {
    AccountDTO getData(Integer shopId) throws Exception;
}
