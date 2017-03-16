package com.mikalai.cucumber.test.account.steps;

import com.mikalai.cucumber.test.account.support.KnowsTheDomain;
import cucumber.api.java.en.Then;
import org.junit.Assert;

/**
 * Created by mikalai on 3/16/2017.
 */
public class CashSlotSteps {

    private KnowsTheDomain helper;

    public CashSlotSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -", dollars, helper.getCashSlot().getContents());
    }
}
