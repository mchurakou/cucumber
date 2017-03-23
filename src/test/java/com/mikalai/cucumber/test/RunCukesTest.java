package com.mikalai.cucumber.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        features = {
                "classpath:features/checkout/checkout.feature",
                "classpath:features/board/tic_tac_toe.feature",
                "classpath:features/account/cash_withdrawal.feature",
                "classpath:features/fruit/fruit_list.feature"
        }

)

public class RunCukesTest {

}
