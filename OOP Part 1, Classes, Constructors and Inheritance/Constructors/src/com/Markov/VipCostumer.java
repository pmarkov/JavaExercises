package com.Markov;

public class VipCostumer {
    private String name;
    private double creditLimit;
    private String email;

    public VipCostumer() {
        this("Default name", 0.0, "Default email");
    }

    public VipCostumer(String name, double creditLimit) {
        this(name, creditLimit, "Default email");
    }

    public VipCostumer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {

        return name;
    }
}
