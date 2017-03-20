package com.mikalai.cucumber.test.account.steps;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.test.account.support.AtmUserInterface;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mikalai on 3/16/2017.
 */
public class TellerSteps {

    @Autowired
    private AtmUserInterface teller;

    @Autowired
    private Account testAccount;

    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(int amount) throws Throwable {
        teller.withdrawFrom(testAccount, amount);
    }

    @Then("^I should see an out-of-order message$")
    public void iShouldSeeAnOutOfOrderMessage() throws Throwable {
        Assert.assertTrue("Expected error message not displayed",
                teller.isDisplaying("Out of order"));
    }

    @Then("^I should see an ask-for-less-money message$")
    public void iShouldSeeAnAskForLessMoneyMessage() throws Throwable {
        Assert.assertTrue("Expected error message not displayed",
                teller.isDisplaying("Insufficient ATM funds"));
    }

    @When("^I type \\$(\\d+)$")
    public void iType$(int amount) throws Throwable {
        teller.type(amount);
    }
}
