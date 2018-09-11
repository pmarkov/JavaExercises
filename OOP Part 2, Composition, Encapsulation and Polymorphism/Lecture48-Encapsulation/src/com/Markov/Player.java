package com.Markov;

public class Player {
    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("The player is knocked out.");
            //Decrease player's lives;
        }
    }

    public int remainingHealth() {
        return health;
    }
}
