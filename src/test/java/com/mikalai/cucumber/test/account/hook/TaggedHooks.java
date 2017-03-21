package com.mikalai.cucumber.test.account.hook;

import com.mikalai.cucumber.test.account.support.AtmInterfaceFactory;
import cucumber.api.java.Before;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Mikalai_Churakou on 3/22/2017.
 */
@ContextConfiguration("classpath:cucumber.xml")
public class TaggedHooks {
    @Before("@bypass_teller_ui")
    public void bypassTellerUI() {
        AtmInterfaceFactory.bypassTellerUI();
    }
}
