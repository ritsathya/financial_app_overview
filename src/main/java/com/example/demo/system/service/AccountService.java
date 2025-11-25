package com.example.demo.system.service;

import com.example.demo.system.exception.InsufficientFundsException;
import com.example.demo.system.exception.InvalidAccountException;
import com.example.demo.system.exception.LimitExceededException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String, BigDecimal> accounts = new HashMap<>();

    public AccountService() {
        accounts.put("A1", new BigDecimal("1500.00"));
        accounts.put("A2", new BigDecimal("500.00"));
    }

    public BigDecimal getBalance(String accountId) {
        if (!accounts.containsKey(accountId)) {
            throw new InvalidAccountException("Account " + accountId + " does not exist");
        }
        return accounts.get(accountId);
    }

    public void transfer(String from, String to, BigDecimal amount) {

        if (!accounts.containsKey(from)) {
            throw new InvalidAccountException("Sender account not found: " + from);
        }

        if (!accounts.containsKey(to)) {
            throw new InvalidAccountException("Receiver account not found: " + to);
        }

        BigDecimal fromBalance = accounts.get(from);

        if (fromBalance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Not enough balance");
        }

        if (amount.compareTo(new BigDecimal("1000")) > 0) {
            throw new LimitExceededException("Transfer exceeds allowed limit");
        }

        // If all checks pass → process transfer
        accounts.put(from, fromBalance.subtract(amount));
        accounts.put(to, accounts.get(to).add(amount));
    }
}
