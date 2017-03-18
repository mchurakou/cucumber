package com.mikalai.cucumber.account.domain;

/**
 * Created by mikalai on 3/16/2017.
 */
public class Account {
    private Money balance = new Money(0,0);
    public void credit(Money amount) {
        balance = balance.add(amount);
    }
    public Money getBalance() {
        return balance;
    }


    public void debit(int dollars) {
        balance = balance.minus(new Money(dollars, 0));
    }
}
