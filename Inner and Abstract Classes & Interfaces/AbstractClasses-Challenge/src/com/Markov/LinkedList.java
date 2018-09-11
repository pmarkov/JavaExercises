package com.Markov;

public class LinkedList{

    private class Node extends ListItem {

        public Node(String element) {
            super(element);
        }

        @Override
        public ListItem moveToNext() {
            return super.moveToNext();
        }

        @Override
        public ListItem moveToPrevious() {
            return super.moveToPrevious();
        }

        @Override
        public void setNext(ListItem next) {
            super.setNext(next);
        }

        @Override
        public void setPrevious(ListItem previous) {
            super.setPrevious(previous);
        }

        @Override
        public int compareTo(String newElement) {
            return super.compareTo(newElement);
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void addItem(String item) {
        if(head == null) {
            head = new Node(item);
            tail = head;
        } else {
            Node currNode = tail;
            tail = new Node(item);
            currNode.setNext(tail);
            tail.setPrevious(currNode);
        }
        length++;
    }

    public void addItem(int index, String item) {
        if(index < 0 || index > length) {
            System.out.println("Invalid index input");
            return;
        }
        if(head == null) {
            head = new Node(item);
            tail = head;
        } else {
            Node newNode = new Node(item);
            if(index == 0) {
                newNode.setNext(head);
                head = newNode;
            } else {
                Node currNode = head;
                int currentIndex = 0;
                while(currentIndex < index - 1) {
                    currNode = (Node)currNode.moveToNext();
                    currentIndex++;
                }
                newNode.setNext(currNode.moveToNext());
                currNode.setNext(newNode);
                newNode.setPrevious(currNode);
            }
        }
        length++;
    }

    public void addInOrder(String newItem) {
        if(head == null) {
            head = new Node(newItem);
            tail = head;
            length++;
        } else {
            int currIndex = 0;
            Node currNode = head;
            while(currNode != null) {
                int check = currNode.compareTo(newItem);
                if(check == 0) {
                    System.out.println(newItem + " is already in the list");
                    return;
                } else if(check > 0) {
                    break;
                }
                currNode = (Node)currNode.moveToNext();
                currIndex++;
            }
            addItem(currIndex, newItem);
        }
    }

    public int removeItem(String item) {

        Node currNode = head;
        while(currNode!=null) {
            if(currNode.compareTo(item) == 0) {
                if(currNode.moveToNext() == null) {
                    currNode.moveToPrevious().setNext(null);
                    tail = (Node)currNode.moveToPrevious();
                } else {
                    currNode.moveToPrevious().setNext(currNode.moveToNext());
                    currNode.moveToNext().setPrevious(currNode.moveToPrevious());
                }
                length--;
                return length;
            }
            currNode = (Node)currNode.moveToNext();
        }
        return -1;
    }

    public void printList() {
        this.printList(head);
    }

    private void printList(Node head) {
        if(head == null) {
            System.out.println("The list is empty");
        } else {
            while(head != null) {
                System.out.println(head.getElement());
                head = (Node)head.moveToNext();
            }
        }
    }

}
