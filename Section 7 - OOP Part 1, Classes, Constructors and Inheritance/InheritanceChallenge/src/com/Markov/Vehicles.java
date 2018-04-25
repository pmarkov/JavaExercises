package com.Markov;

public class Vehicles {

    private int currSpeed;
    private int size;

    public Vehicles(int size) {
        this.currSpeed = 0;
        this.size = size;
    }

    public void setCurrSpeed(int speed) {
            this.currSpeed += speed;
    }

    public int getSpeed() {
        System.out.println("Current speed is " + currSpeed + " km/h.");
        return currSpeed;
    }
    public int getSize() {
        return size;
    }

}
