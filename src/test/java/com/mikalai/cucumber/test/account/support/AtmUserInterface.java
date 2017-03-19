package com.mikalai.cucumber.test.account.support;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.teller.Teller;
import com.mikalai.cucumber.test.account.hook.ServerHooks;
import org.openqa.selenium.By;


/**
 * Created by mikalai on 3/18/2017.
 */
public class AtmUserInterface implements Teller {
    private MyWebDriver webDriver;

    public AtmUserInterface(MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }



    public void withdrawFrom(Account account, int dollars) {
        webDriver.get("http://localhost:" + ServerHooks.PORT);
        webDriver.findElement(By.id("Amount"))
                    .sendKeys(String.valueOf(dollars));
        webDriver.findElement(By.id("Withdraw")).click();
    }
}
