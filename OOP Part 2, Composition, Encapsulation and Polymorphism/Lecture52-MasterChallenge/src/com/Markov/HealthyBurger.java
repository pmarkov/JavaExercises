package com.Markov;

public class HealthyBurger extends Hamburger{

    private boolean tunaFish;
    private boolean olives;
    private double additionalPrice;
    private int additionCount;

    public HealthyBurger(String meat, double basePrice) {
        super("Brown rye", meat, basePrice);
        tunaFish = olives = false;
        this.additionalPrice = 0;
        this.additionCount = 0;
    }

    @Override
    public void addLettuce() {
        super.addLettuce();
        additionCount++;
    }

    @Override
    public void addTomato() {
        super.addTomato();
        additionCount++;
    }

    @Override
    public void addCheese() {
        super.addCheese();
        additionCount++;
    }

    @Override
    public void addPickles() {
        super.addPickles();
        additionCount++;
    }

    public void addTunaFish() {
        if(!tunaFish) {
            tunaFish = true;
            additionalPrice += 0.5;
            additionCount++;
        } else {
            System.out.println("This addition is added already.");
        }
    }

    public void addOlives() {
        if(!olives) {
            olives = true;
            additionalPrice += 0.5;
            additionCount++;
        } else {
            System.out.println("This addition is added already.");
        }
    }

    @Override
    public void showPrice() {
        System.out.printf("The base price of healthy burger with " + super.getMeat() + " on a " +
                super.getBreadRollType() + " bread roll is %.2f", super.getBasePrice());
        System.out.println();
        if(additionCount > 0) {
            super.showAdditions();
            if(tunaFish) {
                System.out.println("Tuna fish - 0.50");
            }
            if(olives) {
                System.out.println("Olives - 0.50");
            }
        }

        System.out.printf("The final price is %.2f", (additionalPrice + super.getFinalPrice()));
        System.out.println("\n");
    }
}
