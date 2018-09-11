package com.Markov;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    private static Bank bank = new Bank();

    public static void main(String[] args) {

        String choice;
        boolean quit = false;
        printOptions();
        while(!quit) {
            System.out.println("Enter your choice(5 - to show options): ");
            choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    addBranch();
                    break;
                case "2":
                    addCustomer();
                    break;
                case "3":
                    addTransaction();
                    break;
                case "4":
                    printCustomers();
                    break;
                case "5":
                    printOptions();
                    break;
                case "6":
                    quit = true;
                    break;
                default:
                    System.out.println("Unrecognized command");

            }

        }


    }

    private static void printOptions() {
        System.out.println("1 - to add a branch\n" +
                "2 - to add a costumer to an existing branch\n" +
                "3 - to add a transaction to an existing costumer from branch\n" +
                "4 - to show the costumers from a particular branch\n" +
                "5 - to show the options\n" +
                "6 - to quit");
    }
    private static void addBranch() {
        System.out.print("Enter branch name: ");
        String branchName = scanner.nextLine();
        if(bank.addBranch(branchName)) {
            System.out.println("Adding " + branchName + " branch was successful\n");
        } else {
            System.out.println("Error with adding the branch\n");
        }
    }

    private static void addCustomer() {
        System.out.print("Enter the branch: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter initial transaction: ");
        Double transaction = scanner.nextDouble();
        scanner.nextLine();
        if(bank.addCustomer(branchName, customerName, transaction)) {
            System.out.println("Adding " + customerName + " to " + branchName + " was successful\n");
        } else {
            System.out.println("Error with adding the customer\n");
        }
    }

    private static void addTransaction() {
        System.out.print("Enter the branch in which is the costumer: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter amount of transaction: ");
        Double transaction = scanner.nextDouble();
        scanner.nextLine();

        if(bank.addTransaction(branchName, customerName, transaction)) {
            System.out.println("Adding transaction to " + customerName + " was successful\n");
        } else {
            System.out.println("Error with adding the transaction\n");
        }
    }

    private static void printCustomers() {
        System.out.print("Enter branch name: ");
        String branchName = scanner.nextLine();
        bank.printCustomers(branchName);
    }
}
