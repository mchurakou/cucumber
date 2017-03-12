package com.mikalai.cucumber.checkout;

/**
 * Created by Mikalai_Churakou on 3/12/2017.
 */
public class Checkout {
    private int runningTotal = 0;

    public void add(int count, int price) {
        runningTotal += (count * price);
    }

    public int total() {
        return runningTotal;

    }

}
