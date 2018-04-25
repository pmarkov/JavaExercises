package com.Markov;

import java.util.*;
import java.util.Iterator;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Song> playlist = new LinkedList<Song>();
    private static ArrayList<Album> albums = new ArrayList<Album>();
    private static ListIterator<Song> currentSong = playlist.listIterator();


    public static void main(String[] args) {

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

        addToPlaylist("Aneliq - Day mi oshte");
        addToPlaylist("Alisiq-Krasavicata spyashta");
        addToPlaylist("Emanuela - Bez chuvstva");
        addToPlaylist("Galena & Fiki - Koy");
        addToPlaylist("Lepa Brena - Luda za tobom");
        addToPlaylist("Stavros Livykos - Skase Skase");


        boolean quit = false;
        boolean flag = false;
        int songIndex = 0;

        System.out.println("!!!Welcome to the best playlist ever created on Earth!!!\n");
        printPlaylist();
        printMenu();


        while(!quit) {

            if (!flag) {
                currentSong(songIndex);
            }

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    System.out.println("Exiting playlist");
                    quit = true;
                    break;
                case 1:
                    if (flag) {
                        songIndex = 0;
                        flag = false;
                    } else {
                        if(songIndex < playlist.size()) {
                            songIndex++;
                        }
                    }
                    break;
                case 2:
                    if(songIndex > 0) {
                        songIndex--;
                    } else {
                        System.out.println("Beginning of the playlist reached");
                        flag = true;
                    }
                    break;
                case 3:
                    break;

                case 4:
                    printPlaylist();
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    System.out.println("Enter the song to be removed: ");
                    removeFromPlaylist(scanner.nextLine());
            }
        }

    }

    private static void printMenu() {
        System.out.println("\nOptions:\n" +
                "0 - To exit the program\n" +
                "1 - Go to the next song\n" +
                "2 - Go to the previous song\n" +
                "3 - Replay the current song\n" +
                "4 - Display songs in the playlist\n" +
                "5 - To print menu\n" +
                "6 - Remove song from the playlist");
    }

    private static void currentSong(int songIndex) {
        ListIterator<Song> iterator = playlist.listIterator(songIndex);

        if(iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println("Now playing: " + song.getTitle() + " - " + song.getDuration());
        } else {
            System.out.println("End of playlist reached");
        }
    }

    private static void addToPlaylist(String name) {
        for (int i = 0; i < albums.size(); i++) {
            Song song = albums.get(i).getSong(name);
            if(song != null) {
                playlist.add(song);
//                System.out.println("The song " + name + " is added to the playlist");
                return;
            }
        }
        System.out.println("The song " + name +" is not in the albums");
    }

    private static void removeFromPlaylist(String title) {
        ListIterator<Song> iterator = playlist.listIterator();

        while(iterator.hasNext()) {
            Song song = iterator.next();
            if(song.getTitle().equals(title)) {
                iterator.remove();
                System.out.println(title + " is removed");
                return;
            }
        }
        System.out.println(title + " is not in the playlist");
    }

    private static void printPlaylist() {
        Iterator<Song> iterator = playlist.iterator();
        int count = 1;

        System.out.println("You have " + playlist.size() + " songs on your playlist:");

        while(iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println((count++) + "." + song.getTitle() + " - " + song.getDuration());
        }
        System.out.println("--------------------------------------");

    }
}
