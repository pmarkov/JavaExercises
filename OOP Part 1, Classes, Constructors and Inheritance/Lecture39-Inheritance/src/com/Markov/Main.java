package com.Markov;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Animal", 1, 1, 5, 5);
        Dog dog = new Dog("Bucky" , 10, 30, 3, 5, 2, 80, "metal");

        dog.eat();
        dog.run();

        Fish fish = new Fish("Carp", 10, 4, 2, 2, 7);

    }
}
