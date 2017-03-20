package com.mikalai.cucumber.test.account.hook;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Mikalai_Churakou on 3/21/2017.
 */

public class SharedDriver extends EventFiringWebDriver {
    
    private static final WebDriver REAL_DRIVER = new FirefoxDriver();
    private static final Thread CLOSE_THREAD = new Thread(() -> REAL_DRIVER.close());

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver() {
        super(REAL_DRIVER);
    }

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException(
                    "You shouldn't close this WebDriver. " +
                            " It's shared and will close when the JVM exits.");
        }
        super.close();
    }

    @Before("@web")
    public void deleteAllCookies() {
        manage().deleteAllCookies();
    }
}
