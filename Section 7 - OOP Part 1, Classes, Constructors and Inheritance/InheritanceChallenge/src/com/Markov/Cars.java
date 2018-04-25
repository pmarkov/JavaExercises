package com.Markov;

public class Cars extends Vehicles {

    private int doors;
    private int wheels;
    private String engine;
    private boolean isManual;

    public Cars(int size, int doors, int wheels, String engine, boolean isManual) {
        super(size);
        this.doors = doors;
        this.wheels = wheels;
        this.engine = engine;
        this.isManual = isManual;
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels() {
        return wheels;
    }

    public String getEngine() {
        return engine;
    }

    public boolean isManual() {
        return isManual;
    }
}
