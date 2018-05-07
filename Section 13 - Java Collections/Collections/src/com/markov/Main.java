package com.markov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);

        if(theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved");
        }
        if(theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved");
        }
        if(theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reversedSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reversedSeats);
        printList(reversedSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13));
        priceSeats.add(theatre. new Seat("A00", 13));

        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);


//        theatre.getSeats();

//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
//        printList(seatCopy);
//        seatCopy.get(1).reserve();
//        if(theatre.reserveSeat("A02")) {
//            System.out.println("Please pay for A02");
//        } else {
//            System.out.println("Seat already reserved");
//        }
//        Collections.shuffle(seatCopy);
//        System.out.println("Printing seatCopy");
//        printList(seatCopy);
//        System.out.println("Printing theatre.seats");
//        printList(theatre.seats);
//
//        Theatre.Seat min = Collections.min(seatCopy);
//        Theatre.Seat max = Collections.max(seatCopy);
//        System.out.println("Min seat number is " + min.getSeatNumber());
//        System.out.println("Max seat number is " + max.getSeatNumber());
//
//        sortList(seatCopy);
//        System.out.println("Printing sorted seatCopy");
//        printList(seatCopy);
    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("=============================================================== ");
    }

}
