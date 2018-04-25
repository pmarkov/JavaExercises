package com.Markov;

import java.util.*;

public class Demo {


    public static void main(String[] args) {

        ArrayList<Album> albums = new ArrayList<Album>();
        LinkedList<Song> playlist = new LinkedList<Song>();

        albums.add(new Album("Chalga"));
        albums.add(new Album("Srubsko"));
        albums.add(new Album("Grucko"));

        albums.get(0).addSong("Alisiq-Krasavicata spyashta", 3.08);
        albums.get(0).addSong("Alisiq & Ilian - Nito duma", 3.29);
        albums.get(0).addSong("Aneliq - Day mi oshte", 4.02);
        albums.get(0).addSong("Aneliq - Milo moe", 3.23);
        albums.get(0).addSong("Emanuela - Bez chuvstva", 3.11);
        albums.get(0).addSong("Galena & Fiki - Koy", 4.10);
        albums.get(0).addSong("Preslava - Pada zvezda", 3.28);
        albums.get(0).addSong("Preslava - Pada zvezda", 3.22);

        albums.get(1).addSong("Aca Lukas - Volis li me", 3.41);
        albums.get(1).addSong("Mile Kitic - Kilo dole kilo gore", 3.44);
        albums.get(1).addSong("CECA - Trepni", 4.19);
        albums.get(1).addSong("Dragan Kojic Keba - Kukavica", 3.53);
        albums.get(1).addSong("Lepa Brena - Luda za tobom", 3.17);
        albums.get(1).addSong("STOJA - Bela ciganka", 3.06);

        albums.get(2).addSong("Mixalis Xatzigiannis - De Fevgo", 3.31);
        albums.get(2).addSong("Kostas Doxas - Happy Day", 3.02);
        albums.get(2).addSong("Nikos Kourkoulis - Poia Eisai Esy", 4.00);
        albums.get(2).addSong("NINO - Theos", 3.40);
        albums.get(2).addSong("Giorgos Papadopoulos - Den To Antexo", 3.52);
        albums.get(2).addSong("Konstantinos Argiros - Ksimeromata", 3.34);
        albums.get(2).addSong("Stavros Livykos - Skase Skase", 3.09);

        addToPlaylist("Aneliq - Day mi oshte", playlist, albums);
        addToPlaylist("Alisiq-Krasavicata spyashta", playlist, albums);
        addToPlaylist("Emanuela - Bez chuvstva", playlist, albums);
        addToPlaylist("Galena & Fiki - Koy", playlist, albums);
        addToPlaylist("Lepa Brena - Luda za tobom", playlist, albums);
        addToPlaylist("Stavros Livykos - Skase Skase", playlist, albums);

        startPlaylist(playlist, albums);

    }

    private static void startPlaylist(LinkedList<Song> playlist, ArrayList<Album> albums) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Song> songListIterator = playlist.listIterator();

        if(playlist.isEmpty()) {
            System.out.println("No songs in the playlist :/");
            printMenu();
        } else {
            System.out.println("!!!Welcome to the best playlist ever created on Earth!!!\n");
            printPlaylist(playlist);
            printMenu();
            currentSong(songListIterator.next());
        }


        while(!quit) {
            System.out.println("(7 - to display the menu)");
            String choice = scanner.nextLine();

            switch(choice) {
                case "0":
                    System.out.println("Exiting playlist");
                    quit = true;
                    break;
                case "1":
                    if(!goingForward) {
                        if(songListIterator.hasNext()) {
                            songListIterator.next();
                            goingForward = true;
                        }
                    }
                    if(songListIterator.hasNext()) {
                        Song song = songListIterator.next();
                        System.out.println("Now playing: " + song.getTitle() + " - " + song.getDuration());
                    } else {
                        System.out.println("End of the playlist reached");
                        goingForward = false;
                    }
                    break;
                case "2":
                    if(goingForward) {
                        if(songListIterator.hasPrevious()) {
                            songListIterator.previous();
                            goingForward = false;
                        }
                    }
                    if(songListIterator.hasPrevious()) {
                        Song song = songListIterator.previous();
                        System.out.println("Now playing: " + song.getTitle() + " - " + song.getDuration());
                    } else {
                        System.out.println("You are at the beginning of the playlist");
                        goingForward = true;
                    }
                    break;
                case "3":
                    if(goingForward) {
                        if(songListIterator.hasPrevious()) {
                            currentSong(songListIterator.previous());
                            goingForward = false;
                        }
                    } else {
                        if(songListIterator.hasNext()) {
                            currentSong(songListIterator.next());
                            goingForward = true;
                        }
                    }

                    break;

                case "4":
                    System.out.println("Enter the song to be removed: ");
                    String title = scanner.nextLine();
                    boolean flag = true;

                    while(songListIterator.hasPrevious()) {
                        songListIterator.previous();
                    }
                    while(songListIterator.hasNext()) {
                        Song song = songListIterator.next();
                        if(song.getTitle().equals(title)) {
                            songListIterator.remove();
                            System.out.println(title + " is removed");
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        System.out.println(title +" is not in the playlist");
                    }
                    goingForward = true;
                    break;
                case "5":
                    System.out.println("Enter the song to be added: ");
                    title = scanner.nextLine();
                    Song song = findSong(title, albums);
                    if(song != null) {
                        while(songListIterator.hasNext()) {
                            songListIterator.next();
                        }
                        songListIterator.add(song);
                        System.out.println(title +" is added to your playlist");
                        currentSong(song);
                        goingForward = true;
                    } else {
                        System.out.println(title + " is not found in your albums");
                    }

                    break;
                case "6":
                    printPlaylist(playlist);
                    break;
                case "7":
                    printMenu();
                    break;
            }

        }


    }

    private static void printMenu() {
        System.out.println("Options:\n" +
                "0 - To exit the program\n" +
                "1 - Go to the next song\n" +
                "2 - Go to the previous song\n" +
                "3 - Replay the current song\n" +
                "4 - Remove song from the playlist\n" +
                "5 - Add song to the playlist\n" +
                "6 - Display songs in the playlist\n" +
                "7 - To print menu\n");
    }

    private static void currentSong(Song song) {
        System.out.println("Now playing: " + song.getTitle() + " - " + song.getDuration());
    }

    private static void printPlaylist(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        int count = 1;

        System.out.println("You have " + playlist.size() + " songs on your playlist:");

        while(iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println((count++) + "." + song.getTitle() + " - " + song.getDuration());
        }
        System.out.println("--------------------------------------");

    }

    private static Song findSong(String title, ArrayList<Album> albums) {
        for (int i = 0; i < albums.size(); i++) {
            Song song = albums.get(i).getSong(title);
            if(song != null) {
                return song;
            }
        }
        return null;
    }

    private static void addToPlaylist(String title, LinkedList<Song> playlist, ArrayList<Album> albums) {

        for (int i = 0; i < albums.size(); i++) {
            Song song = albums.get(i).getSong(title);
            if(song != null) {
                playlist.add(song);
                return;
            }
        }
        System.out.println("The song " + title +" is not in the albums");
    }


}
