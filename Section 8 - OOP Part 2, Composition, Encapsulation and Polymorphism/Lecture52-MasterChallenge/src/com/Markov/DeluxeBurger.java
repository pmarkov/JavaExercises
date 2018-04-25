package com.Markov;

public class DeluxeBurger extends Hamburger{

    private double chipsCost;
    private double drinksCost;
    private double finalPrice;

    public DeluxeBurger(String breadRollType, String meat, double basePrice) {
        super(breadRollType, meat, basePrice);
        this.chipsCost = 1;
        this.drinksCost = 1.5;
        finalPrice = basePrice + chipsCost + drinksCost;
    }

    @Override
    public void addLettuce() {
        System.out.println("This addition cannot be added");
    }

    @Override
    public void addTomato() {
        System.out.println("This addition cannot be added");
    }

    @Override
    public void addCheese() {
        System.out.println("This addition cannot be added");
    }

    @Override
    public void addPickles() {
        System.out.println("This addition cannot be added");
    }

    @Override
    public void showPrice() {
        System.out.printf("The base price of deluxe burger with " + super.getMeat() + " on a " +
                super.getBreadRollType() + " bread roll is %.2f", super.getBasePrice());
        System.out.println();
        showAdditions();
        System.out.printf("The final price is %.2f", (super.getBasePrice() + chipsCost + drinksCost));
        System.out.println("\n");
    }

    @Override
    public double getFinalPrice() {
        return finalPrice;
    }

    @Override
    public void showAdditions() {
        System.out.println("Additions are:");
        System.out.printf("Chips - %.2f", chipsCost);
        System.out.printf("\nDrink - %.2f", drinksCost);
        System.out.println();
    }
}
