package com.mikalai.cucumber.test.account.hook;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.store.TransactionQueue;
import com.mikalai.cucumber.test.account.support.AtmInterfaceFactory;
import cucumber.api.java.Before;
import org.javalite.activejdbc.Base;

public class ResetHooks {

    @Before(order = 1, value="@balancestore")
    public void reset() {
        if (!Base.hasConnection()) {
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller", "password");
        }
        Account.deleteAll();
        TransactionQueue.clear();
    }

    @Before(order = 1)
    public void resetFactory() {
        AtmInterfaceFactory.reset();
    }

}