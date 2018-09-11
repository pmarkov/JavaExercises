package com.Markov;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(20, true);

        printer.printPage(11);
        printer.fillToner(35);
        printer.printPage(11);
        System.out.println(printer.getPagesPrinted() + " pages printed");
        printer.printPage(-1);
    }
}
