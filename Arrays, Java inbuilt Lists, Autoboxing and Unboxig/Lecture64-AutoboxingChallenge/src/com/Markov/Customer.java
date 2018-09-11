package com.Markov;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions.add(initialTransaction);
    }

    public void addTransaction(double newTransaction) {
        transactions.add(newTransaction);
    }

    public void printTransactions() {
        for(int i = 0; i < transactions.size(); i++) {
            System.out.println("Transaction No." + (i + 1) + " - " + transactions.get(i));
        }
    }

    public String getName() {
        return this.name;
    }

}
