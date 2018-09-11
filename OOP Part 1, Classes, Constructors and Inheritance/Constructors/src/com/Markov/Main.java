package com.Markov;

public class Main {

    public static void main(String[] args) {

        BankAccount Me = new BankAccount();
//        BankAccount Me = new BankAccount("12345", 0.00, "Pavel", "pavkata01@abv.bg", "074234123");
        System.out.println("Current balance - " + Me.getBalance());
        Me.deposit(500);
        Me.withdrawal(600);
        System.out.println("Your account number is " + Me.getAccountNumber());
        System.out.println("Your name is " + Me.getName());
        System.out.println("Your email is " + Me.getEmail());
        System.out.println("Your phone number is " + Me.getPhoneNumber());

        BankAccount timsAccount = new BankAccount("Tim", "tim@gdfgd", "12345");
        System.out.println(timsAccount.getAccountNumber() + " name " + timsAccount.getName());

        VipCostumer person1 = new VipCostumer("Pavel", 100_000);
        System.out.println("Vip costumer " + person1.getName() + " has " + person1.getCreditLimit() + " credit limit and email - "
        + person1.getEmail());
    }
}
