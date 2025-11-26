package com.example.demo.system.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String id;
    private Money balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String id, Money openingBalance) {
        this.id  = id;
        this.balance = openingBalance;
    }

    public void apply(Transaction transaction) {
        this.balance = this.balance.add(transaction.getAmount());
        transactions.add(transaction);
    }

    public Money getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
