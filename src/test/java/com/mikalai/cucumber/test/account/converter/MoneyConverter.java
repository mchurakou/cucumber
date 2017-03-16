package com.mikalai.cucumber.test.account.converter;

import com.mikalai.cucumber.account.Money;
import cucumber.api.Transformer;


/**
 * Created by mikalai on 3/16/2017.
 */
public class MoneyConverter extends Transformer<Money> {
    @Override
    public Money transform(String amount) {
        String[] numbers = amount.substring(1).split("\\.");
        int dollars = Integer.parseInt(numbers[0]);
        int cents = Integer.parseInt(numbers[1]);
        return new Money(dollars, cents);
    }
}
