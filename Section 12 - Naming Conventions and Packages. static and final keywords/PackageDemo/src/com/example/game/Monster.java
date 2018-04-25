package com.example.game;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitpoints;
    private int strength;

    public Monster(String name, int hitpoints, int strength) {
        this.name = name;
        this.hitpoints = hitpoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        ArrayList<String> values = new ArrayList<String>();
        values.add(0, name);
        values.add(1, "" + hitpoints);
        values.add(2, "" + strength);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() > 2) {
            this.name = savedValues.get(0);
            this.hitpoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
        }
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitpoints=" + hitpoints +
                ", strength=" + strength +
                '}';
    }


}
