package com.Markov;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private ArrayList<Song> songs;
//    private LinkedList<Song> songs2;

    public Album(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {

        if(findSong(title) == null) {
            songs.add(new Song(title, duration));
//            System.out.println("The song " + title + " has been added successfully to the album " + name);
            return true;
        }
//        System.out.println("The song " + title + " is already in the album");
        return false;
    }

    public Song getSong(String title) {
        return findSong(title);
    }

    private Song findSong(String songName) {
        for (Song i: songs) {
            if(i.getTitle().equals(songName)) {
                return i;
            }
        }
        return null;
    }

}
