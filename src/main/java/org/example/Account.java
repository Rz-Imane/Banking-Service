package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public final class Account implements AccountService {

    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final List<Tx> txs = new ArrayList<>();
    private int balance;

    @Override
    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        balance += amount;
        txs.add(new Tx(LocalDate.now(), amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) throw new IllegalArgumentException();
        if (amount > balance) throw new IllegalArgumentException();
        balance -= amount;
        txs.add(new Tx(LocalDate.now(), -amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("Date || Amount || Balance");
        for (int i = txs.size() - 1; i >= 0; i--) {
            Tx t = txs.get(i);
            System.out.println(t.date.format(DF) + " || " + t.amount + " || " + t.balance);
        }
    }

    private static final class Tx {
        final LocalDate date;
        final int amount;
        final int balance;

        Tx(LocalDate date, int amount, int balance) {
            this.date = date;
            this.amount = amount;
            this.balance = balance;
        }
    }
}
