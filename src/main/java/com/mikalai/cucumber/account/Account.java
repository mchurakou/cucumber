package com.mikalai.cucumber.account;

/**
 * Created by mikalai on 3/16/2017.
 */
public class Account {
    private Money balance = new Money(0,0);
    public void deposit(Money amount) {
        balance = balance.add(amount);
    }
    public Money getBalance() {
        return balance;
    }
}
