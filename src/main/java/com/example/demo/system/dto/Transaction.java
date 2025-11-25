package com.example.demo.system.dto;

import java.time.LocalDateTime;

public class Transaction {
    private final String id;
    private final String accountId;
    private final Money amount;
    private final LocalDateTime timestamp;

    public Transaction(String id, String accountId, Money amount) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getAccountId() {
        return accountId;
    }

    public Money getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return timestamp.toString() + " TID: " + id + " ACC_ID: " + accountId + " AMT: " + amount.toString();
    }
}
