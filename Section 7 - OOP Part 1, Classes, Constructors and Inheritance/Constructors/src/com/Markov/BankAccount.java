package com.Markov;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String name;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        this("000000", 0.0, "Default name", "Default email", "Default phone number");
        System.out.println("Empty account created.");
    }
    public BankAccount(String accountNumber, double balance, String name, String email, String phoneNumber){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Account with parameters created.");
    }

    public BankAccount(String name, String email, String phoneNumber) {
        this("999999", 0.0, name, email, phoneNumber);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void deposit (int deposit) {
        this.balance += deposit;
        System.out.println("Deposit of " + deposit + " made. Your balance is " + this.balance);
    }
    public void withdrawal (int withdrawal) {
        if(withdrawal > this.balance) {
            System.out.println("You're too poor :/ Only " + this.balance + " available.");
        } else {
            this.balance -= withdrawal;
            System.out.println("Withdrawal of " + withdrawal + " processed. Your balance is " + this.balance);
        }
    }
    public double getBalance() {
        return this.balance;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
