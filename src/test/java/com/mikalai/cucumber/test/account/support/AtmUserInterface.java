package com.mikalai.cucumber.test.account.support;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.teller.Teller;
import com.mikalai.cucumber.test.account.hook.ServerHooks;
import org.openqa.selenium.By;


/**
 * Created by mikalai on 3/18/2017.
 */
public class AtmUserInterface implements Teller {
    private KnowsTheDomain helper;

    public AtmUserInterface(KnowsTheDomain helper) {
        this.helper = helper;
    }



    public void withdrawFrom(Account account, int dollars) {
            helper.getWebDriver().get("http://localhost:" + ServerHooks.PORT);
            helper.getWebDriver().findElement(By.id("Amount"))
                    .sendKeys(String.valueOf(dollars));
            helper.getWebDriver().findElement(By.id("Withdraw")).click();
    }
}
