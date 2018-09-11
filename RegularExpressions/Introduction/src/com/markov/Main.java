package com.markov;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeeF12gHiiiiijk99L";
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeeee", "YYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeeee"));
        System.out.println(alphanumeric.matches("abcDeeeeF12gHiiiiijk99L"));

        System.out.println(alphanumeric.replaceAll("ijk99L$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
        System.out.println(alphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(alphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(alphanumeric.replaceAll("[a-f3-8]", "X"));
        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(alphanumeric.replaceAll("\\d", "X"));
        System.out.println(alphanumeric.replaceAll("\\D", "Z"));

        String hasWhitespace = "I have blanks and\ta tab, and also a new line\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        System.out.println(hasWhitespace.replaceAll("\\S", ""));

        String newAlphanumeric = "abcDeeeeF12gHiiiiijk99L";
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));

        System.out.println(hasWhitespace.replaceAll("\\b", "X"));
        System.out.println(hasWhitespace.replaceAll("\\B", "X"));

        System.out.println(newAlphanumeric.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("^abcDe+", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("^abcDe*", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("[Hh]+i*j", "Y"));


        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something</p>");
        htmlText.append("<p>This is another paragraph about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPatter = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPatter);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();
        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroup = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroup);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        String tvTest = "tstvtkt";
//        String tNotVRegEx = "t[^v]";
        String tNotVRegEx = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegEx);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})&
        String phone1 = "1234567890"; // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone1 = " + phone1.matches("^([(][0-9]{3}[)][ ][0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([(][0-9]{3}[)][ ][0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([(][0-9]{3}[)][ ][0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([(][0-9]{3}[)][ ][0-9]{3}[\\-][0-9]{4})$"));

        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444";
        String visa2 = "544444444444";
        String visa3 = "4444444444444444";
        String visa4 = "4444";

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));







    }
}





















