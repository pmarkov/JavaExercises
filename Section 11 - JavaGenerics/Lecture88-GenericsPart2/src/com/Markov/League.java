package com.Markov;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team>{

    private ArrayList<T> teams;
    private String name;

    League(String name) {
        this.name = name;
        teams = new ArrayList<>();
    }

    public void addTeam(T team) {
        if(teams.contains(team)) {
            System.out.println("This team is already in the league");
        } else {
            teams.add(team);
        }
    }

    public String getName() {
        return this.name;
    }

    public void rankTeams() {
        if(teams.isEmpty()) {
            System.out.println("There are no teams in this league");
        } else {
            Collections.sort(teams);
            for(Team i: teams) {
                System.out.println(i.getName() + ": " + i.ranking());
            }
        }
    }

}
