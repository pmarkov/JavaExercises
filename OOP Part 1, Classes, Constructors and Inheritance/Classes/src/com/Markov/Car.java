package com.Markov;

public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engnine;
    private String colour;

    public void setModel(String model) {
        String newValidation = model.toLowerCase();
        if(newValidation.equals("carrera") || newValidation.equals("commodore")) {
            this.model = model;
        } else {
            this.model = "Unknown";
        }
    }

    public String getModel() {
        return this.model;
    }
}
