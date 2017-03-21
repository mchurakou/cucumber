package com.mikalai.cucumber.test.account.support;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.CashSlot;
import com.mikalai.cucumber.account.domain.teller.AutomatedTeller;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Mikalai_Churakou on 3/22/2017.
 */
public class AtmProgrammaticInterface implements AtmInterface {
    @Autowired
    private CashSlot cashSlot;
    RuntimeException runtimeException;
    public void withdrawFrom(Account account, int amount) {
        try {
           new AutomatedTeller(cashSlot).withdrawFrom(account, amount);
        } catch (RuntimeException e){
            runtimeException = e;
        }
    }
    public void type(int amount) {
// NOTHING TO BE DONE
    }
    public boolean isDisplaying(String message) {
// SHOULD THIS BE true OR false OR throw new NotImplementedException();?
        return true;
    }
}
