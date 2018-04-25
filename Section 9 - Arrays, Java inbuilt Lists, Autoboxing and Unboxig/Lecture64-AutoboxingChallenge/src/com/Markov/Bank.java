package com.Markov;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branches = new ArrayList<Branch>();

    public boolean addBranch(String name) {

        if(existingBranch(name) != null) {
            System.out.println("The bank already has this branch");
            return false;
        }
        Branch newBranch = new Branch(name);
        branches.add(newBranch);
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = existingBranch(branchName);
        if(branch != null) {
            if(branch.addCustomer(customerName, initialTransaction)) {
                return true;
            }
            return false;
        }
        System.out.println("This branch hasn't been found");
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double transaction) {
        Branch branch = existingBranch(branchName);
        if(branch != null) {
            if(branch.addTransaction(customerName, transaction)) {
                return true;
            }
            return false;
        }
        System.out.println("This branch hasn't been found");
        return false;
    }

    public void printCustomers(String branchName) {
        Branch branch = existingBranch(branchName);
        if(branch != null) {
            branch.printCustomers();
        } else {
            System.out.println("This branch hasn't been found");
        }
    }


    private Branch existingBranch(String branchName) {
//        for (int i = 0; i < branches.size(); i++) {
//            if(branches.get(i).getBranchName().equals(branchName)) {
//                return branches.get(i);
//            }
//        }

        for(Branch i : branches) {
            if(i.getBranchName().equals(branchName)) {
                return i;
            }
        }
        return null;
    }



}
