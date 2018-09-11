package com.Markov;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Pavkata", 10000.50);

        Customer anotherCustomer = null;
        anotherCustomer = customer;
        anotherCustomer.setBalance(5000);

        System.out.println("Customer " + customer.getName() + " has balance " + customer.getBalance());


    }
}
