package com.mikalai.cucumber.test.account.hook;

import com.mikalai.cucumber.test.account.support.KnowsTheDomain;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

/**
 * Created by mikalai on 3/18/2017.
 */
public class WebDriverHooks {
    private KnowsTheDomain helper;

    public WebDriverHooks(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @After(order = 3,  value = "@web")
    public void finish(Scenario scenario) {
        try {
            byte[] screenshot = helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            helper.getWebDriver().close();
        }
    }
}
