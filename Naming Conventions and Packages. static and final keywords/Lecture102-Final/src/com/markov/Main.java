package com.markov;

public class Main {

    public static void main(String[] args) {

        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        int pw = 674312;
        Password password = new Password(pw);
        password.storePassword();

        password.letMeIn(1);
        password.letMeIn(132243);
        password.letMeIn(0);
        password.letMeIn(-123);
        password.letMeIn(674312);

    }
}
