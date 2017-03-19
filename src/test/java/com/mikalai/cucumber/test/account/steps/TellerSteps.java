package com.mikalai.cucumber.test.account.steps;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.teller.Teller;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mikalai on 3/16/2017.
 */
public class TellerSteps {

    @Autowired
    private Teller teller;

    @Autowired
    private Account testAccount;

    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(int amount) throws Throwable {
        teller.withdrawFrom(testAccount, amount);
    }
}
