package com.mikalai.cucumber.test.account.support;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by mikalai on 3/19/2017.
 */
public class MyWebDriver extends EventFiringWebDriver {
    public MyWebDriver() {
        super(new FirefoxDriver());
    }
}
