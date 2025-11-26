package com.example.demo.system.model;

public class DomesticTransaction extends TransactionDemo {

    public DomesticTransaction(String id, Money amount) {
        super(id, amount);
    }

    @Override
    public void process() {
        System.out.println("DomesticTransaction starting...");
        System.out.println("ID: " + this.id + " amount: " + this.amount );


    }
}
