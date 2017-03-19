package com.mikalai.cucumber.test.account.steps;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.Money;
import com.mikalai.cucumber.test.account.converter.MoneyConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountSteps {

    @Autowired
    private Account testAccount;



    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void myAccountHasBeenCreditedWith$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        testAccount.credit(amount);
    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;
        while (!testAccount.getBalance().equals(amount)
                && timeoutMilliSecs > 0){
            Thread.sleep(pollIntervalMilliSecs);
            timeoutMilliSecs -= pollIntervalMilliSecs;
        }


        Assert.assertEquals("Incorrect account balance -", amount, testAccount.getBalance());
    }


}