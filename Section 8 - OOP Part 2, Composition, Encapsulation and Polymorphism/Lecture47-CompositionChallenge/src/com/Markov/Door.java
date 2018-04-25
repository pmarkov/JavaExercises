package com.Markov;

public class Door {
    private String doorType;
    private Dimensions dimensions;
    private String color;
    private int isOpen = 0;

    public Door(String doorType, Dimensions dimensions, String color) {
        this.doorType = doorType;
        this.dimensions = dimensions;
        this.color = color;
    }

    public void openDoor() {
        if(isOpen == 0) {
            System.out.println("The door is opened.");
            isOpen = 1;
        } else {
            System.out.println("The door is already opened.");
        }
    }
    public void closeDoor() {
        if(isOpen == 1) {
            System.out.println("The door is closed.");
            isOpen = 0;
        } else {
            System.out.println("The door is already closed.");
        }
    }

    public String getDoorType() {
        return doorType;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getColor() {
        return color;
    }
}
