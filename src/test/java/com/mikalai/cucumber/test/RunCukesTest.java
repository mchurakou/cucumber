package com.mikalai.cucumber.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        features = {"classpath:features/checkout.feature", "classpath:features/tic_tac_toe.feature"}
)

public class RunCukesTest {
}
