package com.mikalai.cucumber.test.account.steps;

import com.mikalai.cucumber.account.domain.Money;
import com.mikalai.cucumber.test.account.converter.MoneyConverter;
import com.mikalai.cucumber.test.account.support.TestAccountHelper;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class AccountSteps {


    private TestAccountHelper testAccount;

    public AccountSteps(TestAccountHelper testAccount) {
        this.testAccount = testAccount;
    }


    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void myAccountHasBeenCreditedWith$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        testAccount.getMyAccount().credit(amount);
    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;
        while (!testAccount.getMyAccount().getBalance().equals(amount)
                && timeoutMilliSecs > 0){
            Thread.sleep(pollIntervalMilliSecs);
            timeoutMilliSecs -= pollIntervalMilliSecs;
        }


        Assert.assertEquals("Incorrect account balance -", amount, testAccount.getMyAccount().getBalance());
    }


}