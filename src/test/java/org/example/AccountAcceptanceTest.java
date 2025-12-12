package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountAcceptanceTest {

    @Test
    void deposit_and_withdraw_work_in_a_normal_flow() {
        Account a = new Account();
        a.deposit(1000);
        a.withdraw(200);
        a.withdraw(800);
        assertThrows(IllegalArgumentException.class, () -> a.withdraw(1));
    }


    @Test
    void deposit_rejects_invalid_amount() {
        Account a = new Account();
        assertThrows(IllegalArgumentException.class, () -> a.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> a.deposit(-10));
    }

    @Test
    void withdraw_rejects_invalid_amount() {
        Account a = new Account();
        assertThrows(IllegalArgumentException.class, () -> a.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> a.withdraw(-1));
    }

    @Test
    void withdraw_fails_when_insufficient_funds() {
        Account a = new Account();
        a.deposit(100);
        assertThrows(IllegalArgumentException.class, () -> a.withdraw(101));
    }


}
