package com.Markov;

public class Window {
    private Dimensions dimensions;
    private int windowsNumber;
    private String windowType;

    public Window(Dimensions dimensions, int windowsNumber, String windowType) {
        this.dimensions = dimensions;
        this.windowsNumber = windowsNumber;
        this.windowType = windowType;
    }

    public void windowCondition(int isOpen) {
        if(isOpen == 1) {
            System.out.println("The window is opened.");
        } else {
            System.out.println("The window is closed.");
        }
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public int getWindowsNumber() {
        return windowsNumber;
    }

    public String getWindowType() {
        return windowType;
    }
}
