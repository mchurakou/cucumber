package com.mikalai.cucumber.account.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mikalai on 3/16/2017.
 */
public class Money {
    private int dolar;
    private int cent;

    public Money(int dolar, int cent) {
        this.dolar = dolar;
        this.cent = cent;
    }

    public Money(String amount) {
        Pattern pattern = Pattern.compile("^[^\\d]*([\\d]+)\\.([\\d][\\d])$");
        Matcher matcher = pattern.matcher(amount);
        matcher.find();
        this.dolar = Integer.parseInt(matcher.group(1));
        this.cent = Integer.parseInt(matcher.group(2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Money))
            return false;
        Money money = (Money) o;
        return dolar == money.dolar &&
                cent == money.cent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dolar, cent);
    }

    public int getDolar() {
        return dolar;

    }

    public int getCent() {
        return cent;
    }

    @Override
    public String toString() {
        return "Money{" +
                "dolar=" + dolar +
                ", cent=" + cent +
                '}';
    }

    public Money add(Money amount) {
        return new Money(this.dolar + amount.dolar, this.cent + amount.cent);
    }


    public Money minus(Money amount) {
        return new Money(this.dolar - amount.dolar, this.cent - amount.cent);
    }
}
