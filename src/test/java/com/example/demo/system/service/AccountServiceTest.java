package com.example.demo.system.service;

import com.example.demo.system.exception.InsufficientFundsException;
import com.example.demo.system.exception.InvalidAccountException;
import com.example.demo.system.exception.LimitExceededException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountServiceTest {
    private AccountService service;

    @BeforeEach
    void setup() {
        service = new AccountService();
    }

    @Test
    void testInvalidAccountException() {
        assertThrows(
                InvalidAccountException.class,
                () -> service.getBalance("ZZZ")
        );
    }

    @Test
    void testInsufficientFundsException() {
        assertThrows(
                InsufficientFundsException.class,
                () -> service.transfer("A1", "A2", new BigDecimal("5000"))
        );
    }

    @Test
    void testLimitExceededException() {
        assertThrows(
                LimitExceededException.class,
                () -> service.transfer("A1", "A2", new BigDecimal("1500"))
        );
    }

    @Test
    void testValidTransferDoesNotThrow() {
        service.transfer("A1", "A2", new BigDecimal("10"));
        // no exception thrown → success
    }
}
