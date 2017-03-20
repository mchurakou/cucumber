package com.mikalai.cucumber.test.account.steps;

import com.mikalai.cucumber.test.account.support.TestCashSlot;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mikalai on 3/16/2017.
 */
public class CashSlotSteps {

    @Autowired
    private TestCashSlot cashSlot;

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Assert.assertEquals("Incorrect amount dispensed -", dollars, cashSlot.getContents());
    }

    @But("^the cash slot has developed a fault$")
    public void theCashSlotHasDevelopedAFault() throws Throwable {
        cashSlot.injectFault();
    }

    @And("^the ATM contains \\$(\\d+)$")
    public void theATMContains$(int amount) throws Throwable {
        cashSlot.load(amount);
    }


}
