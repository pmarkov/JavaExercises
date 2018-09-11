package com.Markov;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        if (tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            System.out.println("Invalid toner level input!");
            this.tonerLevel = -1;
        }
        this.isDuplex = isDuplex;
        this.pagesPrinted = 0;
    }

    public void printPage(int amount) {
        if (tonerLevel < (5 * amount)) {
            System.out.println("The toner needs to be filled.");
            System.out.println("There is " + tonerLevel + " left(" + (5 * amount) + " needed)");
        } else if(amount < 0) {
            System.out.println("Invalid amount of pages");
        } else if (isDuplex) {
            if (amount % 2 == 0) {
                System.out.println("The printer is duplex - " + (amount / 2) + " sheets used");
            } else {
                System.out.println("The printer is duplex - " + (amount / 2 + 1) + " sheets used");
            }
            pagesPrinted += amount;
            tonerLevel -= (5 * amount);
        } else {
            System.out.println("The printer isn't duplex - " + amount + " sheets used for " + amount + " pages");
            pagesPrinted += amount;
            tonerLevel -= (5 * amount);
        }
    }

    public void fillToner(int amountToner) {
        if((amountToner + tonerLevel) >= 5 && (amountToner + tonerLevel) <= 100) {
            tonerLevel += amountToner;
        } else if(amountToner < 5) {
            System.out.println("Not enough toner");
        } else if((amountToner + tonerLevel) > 100) {
            System.out.println("Too much toner!");
        }
    }

    public int getTonerLevel() {
        return tonerLevel;
    }
    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
