package com.markov;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("12345-678", 1000.0);

        Thread customer1 = new Thread(() -> {
            account.deposit(300.0);
            System.out.println("Customer 1: deposit 300, balance is " + account.getBalance());
            account.withdraw(50.0);
            System.out.println("Customer 1: withdraw 50, balance is " + account.getBalance());
        });

        Thread customer2 = new Thread(() -> {
            account.deposit(203.75);
            System.out.println("Customer 2: deposit 203.75, balance is " + account.getBalance());
            account.withdraw(100.0);
            System.out.println("Customer 2: withdraw 100, balance is " + account.getBalance());
        });

        customer1.start();
        customer2.start();
    }
}
