package com.mikalai.cucumber.test.account.hook;

import com.mikalai.cucumber.account.store.TransactionQueue;
import cucumber.api.java.Before;

public class ResetHooks {
    @Before("@balancestore")
    public void reset() {
        TransactionQueue.clear();
    }
}