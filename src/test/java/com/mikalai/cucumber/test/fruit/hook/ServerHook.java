package com.mikalai.cucumber.test.fruit.hook;

import com.mikalai.cucumber.fruit.FruitServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by Mikalai_Churakou on 3/23/2017.
 */
public class ServerHook {
    public static final int PORT = 8887;




    private FruitServer server;

    @Before("@ws")
    public void startServer() throws Exception {
        server = new FruitServer(PORT);
        server.start();
    }

    @After("@ws")
    public void stopServer() throws Exception {
        server.stop();
    }
}
