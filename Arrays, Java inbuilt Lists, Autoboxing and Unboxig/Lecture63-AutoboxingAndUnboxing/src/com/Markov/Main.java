package com.Markov;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Integer integer = new Integer(100);

//        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
//
//        for (int i = 0; i < 10; i++) {
//            integerArrayList.add(Integer.valueOf(i));
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i + " --> " + integerArrayList.get(i).intValue());
//        }

        Integer myIntValue = 56; // Integer.valueOf(56);
        int myInt = myIntValue;  // myIntValue.intValue();

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();

        for(double dbl = 0.0; dbl <= 10.0; dbl+=0.5) {
            myDoubleValues.add(dbl);
        }
        for(int i = 0; i < myDoubleValues.size(); i++) {
            System.out.println(i + " --> " + myDoubleValues.get(i));
        }



    }
}
