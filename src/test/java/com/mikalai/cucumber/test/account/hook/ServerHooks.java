package com.mikalai.cucumber.test.account.hook;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.CashSlot;
import com.mikalai.cucumber.account.web.AtmServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class ServerHooks {
    public static final int PORT = 9988;
    private AtmServer server;


    @Autowired
    private Account testAccount;

    @Autowired
    private CashSlot cashSlot;

    @Before(order = 2, value = "@web")
    public void startServer() throws Exception {
        server = new AtmServer(PORT, cashSlot, testAccount);
        server.start();
    }
    @After(order = 2, value = "@web")
    public void stopServer() throws Exception {
        server.stop();
    }
}
