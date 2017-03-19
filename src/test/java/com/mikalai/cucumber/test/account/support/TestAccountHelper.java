package com.mikalai.cucumber.test.account.support;

import com.mikalai.cucumber.account.domain.Account;

/**
 * Created by mikalai on 3/19/2017.
 */
public class TestAccountHelper {
    private Account myAccount;

    public Account getMyAccount() {
        if (myAccount == null){
            myAccount = new Account(1234);
            myAccount.saveIt();
        }
        return myAccount;
    }
}
