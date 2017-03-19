package com.mikalai.cucumber.test.account.support;

import com.mikalai.cucumber.account.domain.Account;

/**
 * Created by mikalai on 3/19/2017.
 */
public class AccountFactory {
    public static Account createTestAccount() {
        Account account = new Account(1234);
        account.saveIt();
        return account;
    }
}
