package com.mikalai.cucumber.account.store;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.Money;
import org.javalite.activejdbc.Base;

/**
 * Created by mikalai on 3/18/2017.
 */
public class TransactionProcessor {
    private TransactionQueue queue = new TransactionQueue();

    public void process() {
        if (!Base.hasConnection()){
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller", "password");
        }

        do {
            String message = queue.read();

            if (message.length() > 0) {

                System.out.println("MSG:" + message);

                String[] parts = message.split(",");
                Account account = Account.findFirst("number = ?", parts[1]);
                if (account == null) {
                    throw new RuntimeException("Account number not found: " + parts[1]);
                }
                Money transactionAmount = new Money(parts[0]);
                if (isCreditTransaction(message)) {
                    account.setBalance(account.getBalance().add(transactionAmount));
                } else {
                    account.setBalance(account.getBalance().minus(transactionAmount));
                }
            }
        } while (true);
    }

    private boolean isCreditTransaction(String message) {
        return !message.startsWith("-");
    }
}
