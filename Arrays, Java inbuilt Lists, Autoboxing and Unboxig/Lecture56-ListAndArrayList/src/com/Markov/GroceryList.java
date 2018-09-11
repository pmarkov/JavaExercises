package com.Markov;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list.");
        for(int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
        System.out.println();
    }

    private void modifyGroceryItem(int position, String newItem) {
        String currItem = groceryList.get(position);
        groceryList.set(position, newItem);
        System.out.println(currItem + " at position " + (position + 1) + " has been modified");
    }
    public void modifyGroceryItem(String currItem, String newItem) {
        int position = findItem(currItem);
        if(position >= 0) {
            modifyGroceryItem(position, newItem);
        } else {
            System.out.println("The item is not in the grocery list");
        }
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if(position >= 0) {
            removeGroceryItem(position);
        } else {
            System.out.println("The item is not in the grocery list");
        }
    }
    private void removeGroceryItem(int position) {
        String deletedItem = groceryList.get(position);
        groceryList.remove(position);
        System.out.println(deletedItem + " at position " + (position + 1) + " has been removed.");

    }

    private int findItem(String item) {
        return groceryList.indexOf(item);
    }

    public boolean onFile(String item) {
        if(findItem(item) >= 0) {
            return true;
        }
        return false;
    }
}
