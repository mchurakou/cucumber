package com.mikalai.cucumber.account;

/**
 * Created by mikalai on 3/16/2017.
 */
public class CashSlot {

    private int contents;
    public int getContents() {
        return contents;
    }
    public void dispense(int dollars){
        contents = dollars;
    }
}
