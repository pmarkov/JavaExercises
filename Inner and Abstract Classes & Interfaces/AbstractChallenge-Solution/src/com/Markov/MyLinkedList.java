package com.Markov;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null) {
            // The list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currItem = this.root;
        while(currItem != null) {
            int comparison = currItem.compareTo(newItem);
            if(comparison < 0) {
                // newItem is greater, move right if possible
                if(currItem.next() != null) {
                    currItem = currItem.next();
                } else {
                    // there is no next, so insert at the end of the list
                    currItem.setNext(newItem).setPrevious(currItem);
                    return true;
                }
            } else if (comparison > 0) {
                // newItem is less, insert before
                if(currItem.previous() != null) {
                    currItem.previous().setNext(newItem).setPrevious(currItem.previous());
                    newItem.setNext(currItem).setPrevious(newItem);
                } else {
                    // the node with a previous is the root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                // equal
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null) {
            System.out.println("Deleting value " + item.getValue());
        }

        ListItem currItem = this.root;
        while(currItem != null) {
            int comparison = currItem.compareTo(item);
            if(comparison == 0) {
                if(currItem == this.root) {
                    this.root = currItem.next();
                } else {
                    currItem.previous().setNext(currItem.next());
                    if(currItem.next() != null) {
                        currItem.next().setPrevious(currItem.previous());
                    }
                }
                return true;
            } else if(comparison < 0) {
                currItem = currItem.next();
            } else {
                // We are at an item greater than the one to be deleted
                // so the item is not in the list
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null) {
            System.out.println("The list is empty");
        }
        while(root != null) {
            System.out.println(root.getValue());
            root = root.next();
        }
    }

}
