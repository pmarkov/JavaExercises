package com.Markov;

public class Hamburger {

    private String breadRollType;
    private String meat;
    private double basePrice;
    private double finalPrice;
    private double additionPrice = 0.5;
    private int additionCount;
    private boolean lettuce;
    private boolean tomato;
    private boolean cheese;
    private boolean pickles;

    public Hamburger(String breadRollType, String meat, double basePrice) {
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.basePrice = basePrice;
        this.additionCount = 0;
        this.finalPrice = basePrice;
        lettuce = tomato = cheese = pickles = false;
    }

    private void submitAddition() {
        if(additionCount < 4) {
            finalPrice += additionPrice;
            additionCount++;
        } else {
            System.out.println("No more additions allowed.");
        }
    }

    public void addLettuce() {
        if (!lettuce) {
            submitAddition();
            lettuce = true;
        } else {
            System.out.println("This addition is added already.");
        }
    }

    public void addTomato() {
        if (!tomato) {
            submitAddition();
            tomato = true;
        } else {
            System.out.println("This addition is added already.");
        }
    }

    public void addCheese() {
        if (!cheese) {
            submitAddition();
            cheese = true;
        } else {
            System.out.println("This addition is added already.");
        }
    }

    public void addPickles() {
        if (!pickles) {
            submitAddition();
            pickles = true;
        } else {
            System.out.println("This addition is added already.");
        }
    }

    public void showPrice() {
        System.out.printf("The base price of hamburger with " + this.meat + " on a " +
                this.breadRollType +" bread roll is %.2f", basePrice);
        System.out.println();
        if(additionCount > 0) {
            showAdditions();
        } else {
            System.out.println("There are no additions");
        }
        System.out.printf("The final price is %.2f", finalPrice);
        System.out.println("\n");
    }
    public void showAdditions() {
        System.out.println("Additions are:");
        if(lettuce) {
            System.out.printf("Lettuce - %.2f", additionPrice);
            System.out.println();
        }
        if(tomato) {
            System.out.printf("Tomato - %.2f", additionPrice);
            System.out.println();
        }
        if(cheese) {
            System.out.printf("Cheese - %.2f", additionPrice);
            System.out.println();
        }
        if(pickles) {
            System.out.printf("Pickles - %.2f", additionPrice);
            System.out.println();
        }
//        System.out.println();
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public boolean isTomato() {
        return tomato;
    }

    public boolean isCheese() {
        return cheese;
    }

    public boolean isPickles() {
        return pickles;
    }
}
