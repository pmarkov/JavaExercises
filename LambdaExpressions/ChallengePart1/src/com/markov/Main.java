package com.markov;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                String myString = "Let's split this up into an array";
//                String[] parts = myString.split(" ");
//                for(String part : parts) {
//                    System.out.println(part);
//                }
//            }
//        };

        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part : parts) {
                System.out.println(part);
            }
        };

        Function<String, String> everySecondChar2 = source -> {
            StringBuilder returnVal = new StringBuilder();

            for(int i = 0; i < source.length(); i++) {
                if(i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondCharacter(everySecondChar2, "1234567890"));

        Supplier<String> iLoveJava = () -> "I love Java!";

        System.out.println(iLoveJava.get());
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();

        for(int i = 0; i < source.length(); i++) {
            if(i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    private static String everySecondCharacter(Function<String, String> everySecondCharFunc, String source) {
        return everySecondCharFunc.apply(source);
    }
}
