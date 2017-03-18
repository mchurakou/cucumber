package com.mikalai.cucumber.test.account.hook;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
public class SomeTestHooks {
    @Before(order = 1)
    public void beforeCallingScenario() {
        System.out.println("*********** About to start the scenario.");
    }
    @After(order = 1)
    public void afterRunningScenario(Scenario scenario) {
        System.out.println("*********** Just finished running scenario: "
                + scenario.getStatus());
    }
}