package com.example.series;

public class Series {

    public static long nSum(int n) {
        return (n * (n + 1) / 2);
    }

    public static long factorial(int n) {
        long sum = 1;

        if(n == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public static long fibonacci(int n) {
//        long fNumber = 0;
//        long b = 1;
//        for (int i = 0; i < n; i++) {
//            long temp = fNumber;
//            fNumber = b;
//            b = temp + b;
//        }
//        return fNumber;

        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }

        long fNumber = 0;
        long nMinus1 = 1;
        long nMinus2 = 0;

        for (int i = 1; i < n; i++) {
            fNumber = nMinus1 + nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = fNumber;
        }
        return fNumber;
    }
}
