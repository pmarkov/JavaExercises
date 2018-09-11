package com.markov;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String challenge1 = "I want a bike.";
        System.out.println("Challenge1 - " + challenge1.matches("I want a bike."));

        String challenge2 = "I want a ball.";
        String regExp = "^I want a.*";
//        String regExp = "^I want a \\w+.";
        System.out.println("Challenge1 - " + challenge1.matches(regExp));
        System.out.println("Challenge2 - " + challenge2.matches(regExp));

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println("Challenge1 - " + matcher.matches());
        matcher = pattern.matcher(challenge2);
        System.out.println("Challenge2 - " + matcher.matches());

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println("Challenge5 - " + challenge5.matches("a+b+c+d+e+f+g+"));
        System.out.println("Challenge5 - " + challenge5.matches("[a-g]+"));
        System.out.println("Challenge6 - " + challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));

        String challenge7 = "abcd.1234l";
        System.out.println("Challenge7 - " + challenge7.matches("^\\D+\\.\\d+$"));

        String challenge8 = "abcd.135uvqz.7tzik.999";
        String challenge8RegEx = "(\\D+)\\.(\\d+)";
//        String timSolution8 = "[A-Za-z]+\\.(\\d+)"; use .group(1)
        Pattern pattern8 = Pattern.compile(challenge8RegEx);
        Matcher matcher8 = pattern8.matcher(challenge8);

        while(matcher8.find()) {
            System.out.println("Challenge8 - " + matcher8.group(2));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        String challenge9RegEx = "\\D+\\.(\\d+)\\s";
//        String challenge9RegEx = "[A-Za-z]+\\.(\\d+)\\s"; // Tim's solution
        Pattern pattern9 = Pattern.compile(challenge9RegEx);
        Matcher matcher9 = pattern9.matcher(challenge9);
        while(matcher9.find()) {
            System.out.println("Challenge9 - " + matcher9.group(1));
        }

        matcher9.reset();
        while(matcher9.find()) {
            System.out.println("Challenge10 - occurrence from " + matcher9.start(1) + " to " + (matcher9.end(1) - 1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {12, 15}";
        String regEx11 = "\\{([0-9]+), ([0-9]+)}";
//        String regEx11 = "\\{(\\d+), (\\d+)}"; // reshenieto na Tim
        Pattern pattern11 = Pattern.compile(regEx11);
        Matcher matcher11 = pattern11.matcher(challenge11);

        while(matcher11.find()) {
            System.out.println("Challenge11 - " + matcher11.group(1) + ", " + matcher11.group(2));
        }

        String challenge12 = "11111";
        System.out.println("Challenge12 - " + challenge12.matches("^\\d{5}$"));

        String challenge13 = "11111-1111";
        String challenge13RegEx = "^\\d{5}(-\\d{4})?$";
        System.out.println("Challenge13 - " + challenge13.matches(challenge13RegEx));
        System.out.println("Challenge13 - " + challenge12.matches(challenge13RegEx));


    }
}














