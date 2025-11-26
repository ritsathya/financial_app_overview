package com.example.demo.system.model;

import java.math.BigDecimal;

public final class Money {
    private final BigDecimal amount;
    private final String currency;

    public Money(String value, String currency) {
        this.amount = new BigDecimal(value);
        this.currency = currency;
    }

    public Money add(Money other) {
        BigDecimal newAmount = this.amount.add(other.amount);
        return new Money(newAmount.toString(), currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
