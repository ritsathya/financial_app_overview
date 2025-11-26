package com.example.demo.system.model;

public class InternationalTransaction extends TransactionDemo{
    public InternationalTransaction(String id, Money amount) {
        super(id, amount);
    }

    @Override
    public void process() {
        System.out.println("InternalTransaction starting...");
    }
}
