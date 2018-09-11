package com.markov;

import java.util.ArrayList;

public class Account {
    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        transactions = new ArrayList<>();
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        if(amount > 0) {
            balance += amount;
            transactions.add(amount);
            System.out.println(amount + " deposited. Balance is now " + balance);
        } else {
            System.out.println("Cannot deposit negative sums");
        }
    }

    public void withdraw(int amount) {
        int withdrawal = -amount;
        if(withdrawal < 0) {
            balance += withdrawal;
            transactions.add(withdrawal);
            System.out.println(amount + " withdrawn. Balance is now " + balance);
        } else {
            System.out.println("Cannot withdraw negative sums");
        }
    }

    public void calculateBalance() {
        this.balance = 0;
        for(int i: transactions) {
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }

}
