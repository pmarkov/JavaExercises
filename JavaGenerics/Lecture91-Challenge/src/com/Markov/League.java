package com.Markov;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;
    private ArrayList<T> teams;

    League(String name) {
        this.name = name;
        teams = new ArrayList<>();
    }

    public void addTeam(T team) {
        if(this.teams.contains(team)) {
            System.out.println(team.getName() + " is already in this league");
        } else {
            this.teams.add(team);
        }
    }

    public void rankTeams() {
        if(this.teams.isEmpty()) {
            System.out.println("There are no teams in this league");
        } else {
            Collections.sort(teams);
            for(T i:teams) {
                System.out.println(i.getName() + ": " + i.ranking());
            }
        }
    }

}
