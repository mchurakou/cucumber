package com.mikalai.cucumber.test.account.hook;

import com.mikalai.cucumber.account.domain.CashSlot;
import com.mikalai.cucumber.account.web.AtmServer;
import com.mikalai.cucumber.test.account.support.TestAccountHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServerHooks {
    public static final int PORT = 9988;
    private AtmServer server;

    public ServerHooks(TestAccountHelper testAccount, CashSlot cashSlot) {
        this.cashSlot = cashSlot;
        this.testAccount = testAccount;
    }

    private TestAccountHelper testAccount;
    private CashSlot cashSlot;

    @Before(order = 2, value = "@web")
    public void startServer() throws Exception {
        server = new AtmServer(PORT, cashSlot, testAccount.getMyAccount());
        server.start();
    }
    @After(order = 2, value = "@web")
    public void stopServer() throws Exception {
        server.stop();
    }
}
