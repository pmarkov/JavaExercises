package com.Markov;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public boolean addCustomer(String name, double initialTransaction) {

        if(existingCustomer(name) != null) {
            System.out.println("This customer is already in the branch list");
            return false;
        }
        Customer customer = new Customer(name, initialTransaction);
        customers.add(customer);
        return true;
    }

    public boolean addTransaction(String name, double transaction) {
        Customer customer = existingCustomer(name);
        if(customer != null) {
            customer.addTransaction(transaction);
            return true;
        }
        System.out.println("The customer is not in the branch list");
        return false;
    }

    public void printCustomers() {
        System.out.println("There are " + customers.size() + " customers in this branch");
        for(int i = 0; i < customers.size(); i++) {
            System.out.println((i+1) + "." + customers.get(i).getName());
            System.out.println("With transactions:");
            customers.get(i).printTransactions();
        }

    }

    private Customer existingCustomer(String name) {

//        for(int i = 0; i < customers.size(); i++) {
//            if(customers.get(i).getName().equals(name)) {
//                return customers.get(i);
//            }
//        }

        for (Customer i : customers) {
            if(i.getName().equals(name)) {
                return i;
            }
        }

        return null;
    }

}
