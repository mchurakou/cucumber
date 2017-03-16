package com.mikalai.cucumber.test.account.steps;

import com.mikalai.cucumber.test.account.support.KnowsTheDomain;
import cucumber.api.java.en.When;

/**
 * Created by mikalai on 3/16/2017.
 */
public class TellerSteps {

    private KnowsTheDomain helper;

    public TellerSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(int amount) throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), amount);
    }
}
