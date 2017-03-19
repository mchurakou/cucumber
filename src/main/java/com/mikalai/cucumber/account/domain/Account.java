package com.mikalai.cucumber.account.domain;

import com.mikalai.cucumber.account.store.TransactionQueue;
import org.javalite.activejdbc.Model;

/**
 * Created by mikalai on 3/16/2017.
 */
public class Account extends Model {
    private TransactionQueue queue = new TransactionQueue();


    public Account() {}

    public Account(int number){
        setInteger("number", number);
        setString("balance", "0.00");
    }

    public void credit(Money amount) {
        queue.write("+" + amount.toString() + "," + getNumber());
    }

    public void debit(int dollars) {
        Money amount = new Money(dollars, 0);
        queue.write("-" + amount.toString() + "," + getNumber());
    }

    public int getNumber() {
        return getInteger("number");
    }

    public Money getBalance() {
        refresh();
        return new Money(getString("balance"));
    }

    public void setBalance(Money amount) {
        setString("balance", amount.toString());
        saveIt();
    }
}
