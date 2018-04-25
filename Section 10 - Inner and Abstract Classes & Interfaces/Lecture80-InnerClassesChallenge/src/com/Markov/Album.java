package com.Markov;

import java.util.ArrayList;

public class Album {

    private String name;
    private SongList songList;


    public Album(String name) {
        this.name = name;
        songList = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songList.addSong(title,duration );
    }

    public Song getSong(String title) {
        return songList.findSong(title);
    }

    private class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            songs = new ArrayList<Song>();
        }

        private Song findSong(String songName) {
            for (Song i: songs) {
                if(i.getTitle().equals(songName)) {
                    return i;
                }
            }
            return null;
        }

        private boolean addSong(String title, double duration) {
            if(findSong(title) == null) {
                songs.add(new Song(title, duration));
                return true;
            }
            return false;
        }
    }




}
