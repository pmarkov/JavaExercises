package com.Markov;

public class Main {

    public static void main(String[] args) {

        Mercedes mercedes = new Mercedes(2000, 4, 4, "V8", true, 50, "white", "AMG CLS 63", 300, 6);

        System.out.println("This car has " + mercedes.getDoors() + " doors.");
        System.out.println("There are " + mercedes.getGears() + " gears.");

        mercedes.setCurrGear(1);
        System.out.println("Current gear is " + mercedes.getCurrGear());
        mercedes.getSpeed();
        mercedes.setCurrGear(2);
        System.out.println("Current gear is " + mercedes.getCurrGear());
        mercedes.getSpeed();
        mercedes.setCurrGear(3);
        System.out.println("Current gear is " + mercedes.getCurrGear());
        mercedes.getSpeed();
        mercedes.setCurrGear(4);
        System.out.println("Current gear is " + mercedes.getCurrGear());
        mercedes.getSpeed();
        mercedes.setCurrGear(5);
        System.out.println("Current gear is " + mercedes.getCurrGear());
        mercedes.getSpeed();
        mercedes.setCurrGear(6);
        System.out.println("Current gear is " + mercedes.getCurrGear());
        mercedes.getSpeed();


    }
}
