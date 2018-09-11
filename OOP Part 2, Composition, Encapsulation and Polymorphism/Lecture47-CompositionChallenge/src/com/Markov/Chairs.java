package com.Markov;

public class Chairs {
    private String chairType;
    private int chairsNumber;

    public Chairs(String chairType, int chairsNumber) {
        this.chairType = chairType;
        this.chairsNumber = chairsNumber;
    }

    public String getChairType() {
        return chairType;
    }

    public int getChairsNumber() {
        return chairsNumber;
    }
}
