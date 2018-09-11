package com.Markov;

public class Mercedes extends Cars {

    private int acceleration;
    private String colour;
    private String model;
    private int gears;
    private int currGear;
    private int maxSpeed;

    public Mercedes(int size, int doors, int wheels, String engine, boolean isManual,
                    int acceleration, String colour, String model, int maxSpeed, int gears) {
        super(size, doors, wheels, engine, isManual);
        this.acceleration = acceleration;
        this.colour = colour;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.gears = gears;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public String getColour() {
        return colour;
    }

    public String getModel() {
        return model;
    }

    public void setCurrGear(int currGear) {
        if (currGear > 0 && currGear < (gears + 1)) {
            if(this.currGear < currGear) {
                this.currGear = currGear;
                setCurrSpeed(maxSpeed/gears);
            } else if(this.currGear > currGear) {
                this.currGear = currGear;
                setCurrSpeed(-(maxSpeed/currGear));
            } else {
                System.out.println("You're already in this gear");
            }
        } else {
            System.out.println("Invalid gear input.");
        }
    }

    public int getGears() {
        return gears;
    }

    public int getCurrGear() {
        return currGear;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

}
