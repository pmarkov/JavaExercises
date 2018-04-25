package com.Markov;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private ArrayList<String> statistics;
    private String name;
    private int health;
    private int attackDamage;
    private String weapon;
    private String specialPower;

    public Player(String name, int health, int attackDamage, String weapon, String specialPower) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.weapon = weapon;
        this.specialPower = specialPower;
        this.statistics = new ArrayList<String>();

    }

    public ArrayList<String> getStatistics() {
        return statistics;
    }

    public void setStatistics(ArrayList<String> statistics) {
        this.statistics = statistics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    @Override
    public List<String> returnValues() {
        ArrayList<String> values = new ArrayList<String>();
        values.add(0, name);
        values.add(1, "" + health);
        values.add(2, "" + attackDamage);
        values.add(3, weapon);
        values.add(4, specialPower);

        return values;
    }

    @Override
    public void fillValues(List<String> list) {
        this.name = list.get(0);
        this.health = Integer.parseInt(list.get(1));
        this.attackDamage = Integer.parseInt(list.get(2));
        this.weapon = list.get(3);
        this.specialPower = list.get(4);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackDamage=" + attackDamage +
                ", weapon='" + weapon + '\'' +
                ", specialPower='" + specialPower + '\'' +
                '}';
    }
}
