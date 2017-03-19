package com.mikalai.cucumber.test.account.steps;

import com.mikalai.cucumber.test.account.support.AtmUserInterface;
import com.mikalai.cucumber.test.account.support.TestAccountHelper;
import cucumber.api.java.en.When;

/**
 * Created by mikalai on 3/16/2017.
 */
public class TellerSteps {

    private AtmUserInterface teller;
    private TestAccountHelper testAccount;

    public TellerSteps(AtmUserInterface teller, TestAccountHelper testAccount ) {
        this.teller = teller;
        this.testAccount = testAccount;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(int amount) throws Throwable {
        teller.withdrawFrom(testAccount.getMyAccount(), amount);
    }
}
