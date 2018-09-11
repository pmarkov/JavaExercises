package com.Markov;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        int choice = 0;
        boolean quit = false;
        printInstructions();

        while(!quit) {
            System.out.println("Enter your choice:");
            String choiceOne = scanner.nextLine();
//            choice = Integer.valueOf(choiceOne);
//            scanner.nextLine();
            switch(choiceOne) {
                case "0":
                    printInstructions();
                    break;
                case "1":
                    addContact();
                    break;
                case "2":
                    updateContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    searchContact();
                    break;
                case "5":
                    showContacts();
                    break;
                case "6":
                    quit = true;
            }
        }
    }

    private static void printInstructions() {
        System.out.println(
                "Type\n" +
                "0 - to print instructions\n" +
               "1 - to add contact\n" +
               "2 - to update existing contact\n" +
               "3 - to remove contact\n" +
               "4 - to search for contact\n" +
               "5 - to show contacts\n" +
               "6 - to exit the application"
        );
    }

    private static void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String number = scanner.nextLine();
        Contact newContact = new Contact(name, number);
        mobilePhone.addContact(newContact);
    }

    private static void updateContact() {
        System.out.print("Enter the contact you want to modify: ");
        String name = scanner.nextLine();

        int k;
        do {
            System.out.println("Press\n" + "\t1 - to change number\n" +
            "\t2 - to change name\n" + "Enter your choice: ");
            k = scanner.nextInt();
            scanner.nextLine();
        } while(k != 1 && k != 2);
        if(k == 1) {
            System.out.print("Enter the new number: ");
            String number = scanner.nextLine();
            mobilePhone.updateNumber(name, number);
        } else {
            System.out.println("Enter the new name: ");
            String newName = scanner.nextLine();
            mobilePhone.updateName(name, newName);
        }

    }

    private static void deleteContact() {
        System.out.print("Enter contact you want to delete: ");
        String name = scanner.nextLine();
        mobilePhone.deleteContact(name);
    }

    private static void searchContact() {
        System.out.println("Enter the contact you want to search for: ");
        String name = scanner.nextLine();
        mobilePhone.searchContact(name);
    }

    private static void showContacts() {
        mobilePhone.printContacts();
    }
}
