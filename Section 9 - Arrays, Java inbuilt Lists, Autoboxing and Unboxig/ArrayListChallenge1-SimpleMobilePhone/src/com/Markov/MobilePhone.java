package com.Markov;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void addContact(Contact newContact) {
        if(contacts.indexOf(newContact) < 0) {
            contacts.add(newContact);
            System.out.println("New contact " + newContact.getName() + " - " + newContact.getNumber()
                    + " was created successfully");
        } else {
            System.out.println("This contact already exists");
        }
    }

    public void updateNumber(String name, String newNumber) {
       Contact contact = existingContact(name);
       if(contact != null) {
           contact.setNumber(newNumber);
           System.out.println("The contact has been updated successfully");
       } else {
           System.out.println("The contact is not in the list");
       }
    }

    public void updateName(String oldName, String newName) {
        Contact contact = existingContact(oldName);
        Contact newContact = existingContact(newName);
        if (contact != null && newContact == null) {
            contact.setName(newName);
            System.out.println("The contact has been updated successfully");
        } else if(newContact != null) {
            System.out.println("Contact with name " + newName + " already exists");
        }
        else {
            System.out.println("The contact is not in the list");
        }
    }

    public void deleteContact(String name) {
        Contact contact = existingContact(name);
        if(contact != null) {
            contacts.remove(contact);
            System.out.println(name + " was removed successfully");
        } else {
            System.out.println("The contact doesn't exist");
        }
    }

    public void searchContact(String name) {
        Contact contact = existingContact(name);
        if(contact != null) {
            System.out.println(contact.getName() + " - " + contact.getNumber() + " is in the contact list");
        } else {
            System.out.println(name + " is not in the contact list");
        }
    }

    public void printContacts() {
        int size = contacts.size();
        System.out.println("You have " + size + " contacts");
        for(int i = 0; i < size; i++) {
            System.out.println((i+1) + ". " + contacts.get(i).getName() + " " + contacts.get(i).getNumber());
        }
    }

    private Contact existingContact(String name) {
        for(int i = 0; i < contacts.size(); i++) {
            if(name.equals(contacts.get(i).getName())) {
                return contacts.get(i);
            }
        }
        return null;
    }

}
