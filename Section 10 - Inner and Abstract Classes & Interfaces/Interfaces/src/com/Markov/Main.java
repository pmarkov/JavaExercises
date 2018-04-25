package com.Markov;

public class Main {

    public static void main(String[] args) {

        ITelephone pavelsPhone;
        pavelsPhone = new DeskPhone(123456);
        pavelsPhone.powerOn();
        pavelsPhone.callPhone(123456);
        pavelsPhone.answer();

        pavelsPhone = new MobilePhone(2345678);
        pavelsPhone.powerOn();
        pavelsPhone.callPhone(2345678);
        pavelsPhone.answer();

    }
}
