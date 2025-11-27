package com.example.demo.system.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Money {
    private final BigDecimal amount;
    private final String currency;

    public Money(String value, String currency) {
        if(currency.equals("LAK")) {
            this.amount = new BigDecimal(value).setScale(4, RoundingMode.HALF_UP);
        } else {
            this.amount = new BigDecimal(value);
        }

        this.currency = currency;
    }

    public Money add(Money other) {
        validateCurrency(other);
        BigDecimal newAmount = this.amount.add(other.amount);
        return new Money(newAmount.toString(), currency);
    }

    public Money subtract(Money other) {
        validateCurrency(other);
        BigDecimal newAmount = this.amount.subtract(other.amount);
        return new Money(newAmount.toString(), currency);
    }

    private void validateCurrency(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currency mismatch");
        }
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
