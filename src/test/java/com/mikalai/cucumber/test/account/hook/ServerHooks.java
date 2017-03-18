package com.mikalai.cucumber.test.account.hook;

import com.mikalai.cucumber.account.web.AtmServer;
import com.mikalai.cucumber.test.account.support.KnowsTheDomain;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServerHooks {
    public static final int PORT = 9988;
    private AtmServer server;

    public ServerHooks(KnowsTheDomain helper) {
        this.helper = helper;
    }

    private KnowsTheDomain helper;

    @Before(order = 2, value = "@web")
    public void startServer() throws Exception {
        server = new AtmServer(PORT, helper.getCashSlot(), helper.getMyAccount());
        server.start();
    }
    @After(order = 2, value = "@web")
    public void stopServer() throws Exception {
        server.stop();
    }
}
