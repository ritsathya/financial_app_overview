package com.example.demo;

import com.example.demo.system.dto.Account;
import com.example.demo.system.dto.Money;
import com.example.demo.system.dto.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        /*
         * Lab 1.1 Implement simple immutable Money class
         */
        demoMoneyClass();

        /*
         * Lab 2.1 Create three accounts and apply transactions
         */
        demoAccountAndTransactionClass();

        /*
         * Lab 2.2 Use Set to remove duplicate account IDs
         */
        demoSet();

        /*
         * Lab 2.3 Use Map to store balances and sum them
         */
		demoReduction();


    }

    public static void demoMoneyClass() {
        System.out.println("\nLab 1.1 Implement a simple immutable Money class");

        Money a = new Money("0.10", "USD");
        Money b = new Money("0.20", "USD");

        double balance = 0.1 + 0.2;
        System.out.println(balance);

        System.out.println(a.add(b)); // prints exactly 0.30 USD
    }

    public static void demoAccountAndTransactionClass() {
        System.out.println("\nLab 2.1 Create three accounts and apply transactions");

        Account a1 = new Account("A001", new Money("0", "USD"));
        a1.apply(new Transaction("T001", "A001", new Money("50", "USD")));
        a1.apply(new Transaction("T002", "A001", new Money("-20", "USD")));

        System.out.println(a1.getBalance());

        List<Transaction> txs = a1.getTransactions();
        txs.sort(Comparator.comparing(Transaction::getTimestamp).reversed());
        System.out.println(txs);
    }

    public static void demoSet() {
        System.out.println("\nLab 2.2 Use Set to remove duplicate account IDs");

        List<String> ids = Arrays.asList("A1", "A2", "A3", "A2", "A1");
        Set<String> newIds = new HashSet<>(ids);
        System.out.println(newIds);
    }

    public static void demoReduction() {
        System.out.println("\nLab 2.3 Use Map to store balances and sum them");

        Map<String, Money> balances = new HashMap<>();
        balances.put("A1", new Money("100", "USD"));
        balances.put("A2", new Money("200", "USD"));

        Money totalBalance = balances.values().stream()
                .reduce(new Money("0", "USD"), Money::add);

        System.out.println(totalBalance);
    }

}
