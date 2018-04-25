package com.Markov;

public class Main {

    public static void main(String[] args) {

//        Player player = new Player();
//        player.name = "Pavel";
//        player.health = 20;
//        player.weapon = "sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health " + player.remainingHealth());
//
//        damage = 11;
//        player.health = 2000;
//        player.loseHealth(damage);
//        System.out.println("Remaining health " + player.remainingHealth());


        EnhancedPlayer player1 = new EnhancedPlayer("Pavel", 50, "sword");
        System.out.println("Initial health is " + player1.getHealth());
        player1.loseHealth(30);
        System.out.println("Initial health is " + player1.getHealth());
    }
}
