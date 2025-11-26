package com.example.demo.system.model;

public abstract class TransactionDemo {
    protected String id;
    protected Money amount;

    public TransactionDemo(String id, Money amount) {
        this.id = id;
        this.amount = amount;
    }

    public abstract void process();
}
