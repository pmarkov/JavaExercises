package com.Markov;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("Pavel", 100, 20, "motika", "cepi mraka");
        System.out.println(player1);

        player1.setAttackDamage(1000);
        saveObject(player1);
        System.out.println(player1);

        loadObject(player1);
        saveObject(player1);
        System.out.println(player1);

        Monster monster = new Monster("Golqmata stupka", 1000, 50, "krak");
        saveObject(monster);
        System.out.println(monster);


    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 - to enter a string\n" +
                "0 - to quit");

        while(!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for(int i = 0; i < objectToSave.returnValues().size(); i++) {
            System.out.println("Saving " + objectToSave.returnValues().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.fillValues(values);
    }












}
