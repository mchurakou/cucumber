package com.mikalai.cucumber.test.account.steps;

import com.mikalai.cucumber.account.Money;
import com.mikalai.cucumber.test.account.converter.MoneyConverter;
import com.mikalai.cucumber.test.account.support.KnowsTheDomain;
import cucumber.api.Transform;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class AccountSteps {


    private KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }


    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount) throws Throwable {
        helper.getMyAccount().deposit(amount);
        Assert.assertEquals("Incorrect account balance -", amount, helper.getMyAccount().getBalance());
    }


}