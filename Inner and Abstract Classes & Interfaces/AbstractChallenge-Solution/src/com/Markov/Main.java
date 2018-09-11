package com.Markov;

public class Main {

    public static void main(String[] args) {

        SearchTree tree = new SearchTree(null);

        tree.traverse(tree.getRoot());

        String stringData = "3 5 7 0 6 1 2 9 4 8";

        String[] data = stringData.split(" ");
        for (String i: data) {
            tree.addItem(new Node(i));
        }

        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("2"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("0"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("6"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("4"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("5"));
        tree.traverse(tree.getRoot());
    }
}
