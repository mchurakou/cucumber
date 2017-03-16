package com.mikalai.cucumber.test.checkout;

import com.mikalai.cucumber.checkout.Checkout;
import cucumber.api.java.en.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CheckoutSteps {
    private Checkout checkout = new Checkout();
    private Map<String, Integer> costMap = new HashMap<>();


    @Given("^the price of a \"(.*?)\" is (\\d+)c$")
    public void thePriceOfAIsC(String name, int price) throws Throwable {
        costMap.put(name, price);

    }
    @When("^I checkout (\\d+) \"(.*?)\"$")
    public void iCheckout(int itemCount, String itemName) throws Throwable {

        checkout.add(itemCount, costMap.get(itemName));
    }
    @Then("^the total price should be (\\d+)c$")
    public void theTotalPriceShouldBeC(int total) throws Throwable {
        assertEquals(total, checkout.total());
    }
}
