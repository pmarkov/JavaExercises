package com.Markov;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(this.root == null) {
            this.root = item;
            return true;
        }

        ListItem currentItem = root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if(comparison > 0) {
                if(currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    currentItem.setPrevious(item);
                    return true;
                }
            } else if(comparison < 0) {
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(item);
                    return true;
                }
            } else {
                System.out.println(item.getValue() + " is already in the list");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currItem = this.root;
        ListItem parentItem = currItem;

        while(currItem != null) {
            int comparison = currItem.compareTo(item);
            if(comparison < 0) {
                parentItem = currItem;
                currItem = currItem.next();
            } else if(comparison > 0) {
                parentItem = currItem;
                currItem = currItem.previous();
            } else {
                performRemoval(currItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent ) {
        // remove item from the tree
        if(item.next() == null) {
            // there is no right subtree
            if(parent.next() == item) {
                // the item is the right child of the parent
                parent.setNext(item.previous());
            } else if(parent.previous() == item) {
                // the item is the left child of the parent
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, which means we are looking at the root node
                this.root = item.previous();
            }
        } else if(item.previous() == null) {
            // there is no left subtree
            if(parent.next() == item) {
                // the item is the right child of the parent
                parent.setNext(item.next());
            } else if(parent.previous() == item) {
                // the item is the left child of the parent
                parent.setPrevious(item.next());
            } else {
                // deleting the root
                this.root = item.next();
            }
        } else {
            // the item has both left and right sub-trees
            // from the right sub-tree, find the smallest value (the leftmost node)
            ListItem current = item.next();
            ListItem leftmostParent = item;

            while(current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            // Now put the smallest value into our node to be deleted
            item.setValue(current.getValue());
            // and delete the smallest
            if(leftmostParent == item) {
                // there was no leftmost node, so 'current' points to the smallest
                // node (the one that must now be deleted)
                item.setNext(current.next());
            } else {
                // set the smallest node's parent point to the
                // smallest node's right child(which may be null)
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        // recursive method
        if(root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
