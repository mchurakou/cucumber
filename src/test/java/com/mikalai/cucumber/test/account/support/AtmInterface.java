package com.mikalai.cucumber.test.account.support;

import com.mikalai.cucumber.account.domain.teller.Teller;

/**
 * Created by Mikalai_Churakou on 3/22/2017.
 */
public interface AtmInterface extends Teller {
    boolean isDisplaying(String message);

    void type(int amount);
}
