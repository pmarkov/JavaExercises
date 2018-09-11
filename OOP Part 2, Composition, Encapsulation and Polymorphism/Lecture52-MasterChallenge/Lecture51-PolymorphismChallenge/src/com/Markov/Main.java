package com.Markov;

class Car {
    private String name;
    private int cylinders;
    private int wheels;
    private boolean engine;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.engine = true;
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void startEngine() {
        System.out.println("Starting engine...");
    }

    public void accelerate() {
        System.out.println("Accelerating...");
    }

    public void brake() {
        System.out.println("Braking...");
    }
}

class Mercedes extends Car {
    private int maxSpeed;
    private int currSpeed;

    public Mercedes(int maxSpeed) {
        super("Mercedes SLK", 8);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void startEngine() {
        System.out.println("Mercedes SLK starting engine...");
    }

    @Override
    public void accelerate() {
        currSpeed += (maxSpeed / 5);
        System.out.println("Accelerating with " + maxSpeed/5 + " speed");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCurrSpeed() {
        return currSpeed;
    }
}

class Audi extends Car {
    private int maxSpeed;

    public Audi (int maxSpeed) {
        super("Audi RS6", 6);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void startEngine() {
        System.out.println("Audi RS6 starting engine...");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating with " + maxSpeed/5 + " speed");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}

class BMW extends Car {
    private int maxSpeed;

    public BMW (int maxSpeed) {
        super("BMW M3", 6);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void startEngine() {
        System.out.println("BMW M3 starting engine...");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating with " + maxSpeed/5 + " speed");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}



public class Main {

    public static void main(String[] args) {

        Car car1 = new Mercedes(280);

        car1.startEngine();
        car1.accelerate();
        car1.brake();

        Car car2 = new Audi(300);

        car2.startEngine();
        car2.accelerate();
        car2.brake();

        Car car3 = new BMW(250);

        car3.startEngine();
        car3.accelerate();
        car3.brake();
    }
}
