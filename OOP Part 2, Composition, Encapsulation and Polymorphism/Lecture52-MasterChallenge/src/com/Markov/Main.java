package com.Markov;

public class Main {

    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("white", "bacon", 3);
        hamburger.showPrice();

        hamburger.addCheese();
        hamburger.addPickles();
        hamburger.showPrice();

        HealthyBurger healthyBurger = new HealthyBurger("Chicken", 4.00);
        healthyBurger.addLettuce();
        healthyBurger.addTomato();
        healthyBurger.addTunaFish();
        healthyBurger.showPrice();

        DeluxeBurger deluxeBurger = new DeluxeBurger("Brown", "Pork", 3.50);
        deluxeBurger.addLettuce();
        deluxeBurger.showAdditions();
        System.out.println();
        deluxeBurger.showPrice();

    }
}
