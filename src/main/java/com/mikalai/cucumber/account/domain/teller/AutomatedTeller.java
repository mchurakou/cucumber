package com.mikalai.cucumber.account.domain.teller;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.CashSlot;

/**
 * Created by mikalai on 3/16/2017.
 */
public class AutomatedTeller implements Teller {

    private CashSlot cashSlot;

    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Override
    public void withdrawFrom(Account account, int dollars) {
        account.debit(dollars);
        cashSlot.dispense(dollars);
    }
}
