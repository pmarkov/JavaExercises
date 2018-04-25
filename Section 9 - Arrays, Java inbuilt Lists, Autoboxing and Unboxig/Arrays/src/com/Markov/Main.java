package com.Markov;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntArray = getArray(5);

        for(int i = 0; i < myIntArray.length; i++) {
            System.out.println("Element " + i + " was typed " + myIntArray[i]);
        }
        System.out.println("The average of this numbers is " + average(myIntArray));
    }

    public static int[] getArray(int number) {
        System.out.println("Enter " + number + " integer values\r");

        int[] values = new int[number];
        for(int i = 0; i < number; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static double average(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return (double) sum/ (double)array.length;
    }
}
