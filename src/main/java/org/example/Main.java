package org.example;

public class Main {
    public static void main(String[] args) {
        Account acc = new Account();

        acc.deposit(1000);
        acc.deposit(2000);
        acc.withdraw(500);

        acc.printStatement();
    }
}
