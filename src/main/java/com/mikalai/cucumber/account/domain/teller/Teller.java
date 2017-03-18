package com.mikalai.cucumber.account.domain.teller;

import com.mikalai.cucumber.account.domain.Account;

/**
 * Created by mikalai on 3/18/2017.
 */
public interface Teller {
    void withdrawFrom(Account account, int dollars);
}
