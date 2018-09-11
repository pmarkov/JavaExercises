package com.markov;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private static final int START_LOC = 64;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("SOUTH", "S");

        Location currentLocation = locations.getLocation(START_LOC);

        while(true) {
            System.out.println(currentLocation.getDescription());
            if(currentLocation.getLocationID() == 0) {
                break;
            }
            Map<String, Integer> exits = currentLocation.getExits();
            System.out.print("Available exits are ");
            for(String i : exits.keySet()) {
                System.out.print(i + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word : words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                currentLocation = locations.getLocation(exits.get(direction));
            } else {
                System.out.println("You cannot go in that direction");
            }
        }

        locations.close();
    }
}
