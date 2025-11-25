package com.example.demo.exampleClass;

import java.util.Random;

public class UnreliablePaymentGateway {
    private Random random = new Random();

    public boolean process() {
        int x = random.nextInt(10);
        if (x < 3) {
            throw new RuntimeException("Temporary gateway failure");
        }
        return true;
    }
}
