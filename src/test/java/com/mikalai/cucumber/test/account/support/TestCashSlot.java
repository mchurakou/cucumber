package com.mikalai.cucumber.test.account.support;

import com.mikalai.cucumber.account.domain.CashSlot;

public class TestCashSlot extends CashSlot {
    private boolean faulty;

    public void injectFault() {
        faulty = true;
    }
    public void dispense(int dollars){
        if (faulty) {
            throw new RuntimeException("Out of order");
        } else {
            super.dispense(dollars);
        }
    }

    public TestCashSlot() {
        super.load(1000);
    }
}
