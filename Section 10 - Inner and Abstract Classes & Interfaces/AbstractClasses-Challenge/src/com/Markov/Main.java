package com.Markov;

public class Main {

    public static void main(String[] args) {

        String string = "Some random values to be tested";
        String[] stringData = string.split(" ");
        LinkedList linkedList = new LinkedList();

        for(String i: stringData) {
            linkedList.addItem(i);
        }

        linkedList.addItem(6, "Ala-bala");
        linkedList.addItem(3, "Portokala");
        linkedList.printList();


        if(linkedList.removeItem("tested") < 0) {
            System.out.println("Not in the list");
        }
        linkedList.printList();

    }
}
