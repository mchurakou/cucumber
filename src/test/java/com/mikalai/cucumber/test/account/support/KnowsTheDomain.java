package com.mikalai.cucumber.test.account.support;

import com.mikalai.cucumber.account.Account;
import com.mikalai.cucumber.account.CashSlot;
import com.mikalai.cucumber.account.Teller;

/**
 * Created by mikalai on 3/16/2017.
 */
public class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;
    private Teller teller;

    public Account getMyAccount() {
        if (myAccount == null){
            myAccount = new Account();
        }
        return myAccount;
    }

    public CashSlot getCashSlot() {
        if (cashSlot == null){
            cashSlot = new CashSlot();
        }
        return cashSlot;
    }


    public Teller getTeller() {
        if (teller == null){
            teller = new Teller(getCashSlot());
        }
        return teller;
    }
}
