package com.Markov;

public class Floor {
    private String floorType;
    private Dimensions dimensions;

    public Floor(String floorType, Dimensions dimensions) {
        this.floorType = floorType;
        this.dimensions = dimensions;
    }

    public String getFloorType() {
        return floorType;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
