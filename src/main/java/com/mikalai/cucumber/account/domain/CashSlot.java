package com.mikalai.cucumber.account.domain;

/**
 * Created by mikalai on 3/16/2017.
 */
public class CashSlot {

    private int contents;
    private int available;

    public int getContents() {
        return contents;
    }
    public void dispense(int requested){
        if (available >= requested) {
            contents = requested;
            available -= requested;
        } else {
            throw new RuntimeException("Insufficient ATM funds");
        }
    }

    public void load(int dollars){
        available = dollars;
    }

    public boolean canDispense(int amount) {
        return available >= amount;
    }
}
