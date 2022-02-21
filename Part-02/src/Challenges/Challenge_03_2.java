package Challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Challenge 3 - Regular Expression
public class Challenge_03_2 {
    public static void main(String[] args) {

        // Challenge 1 -
        String challenge1 = "I want a bike";
        System.out.println(challenge1.matches("I want a bike"));

        // Challenge 2 -
//        String reg = "I want a \\w+";
        String reg = "I want a (bike|ball)";
        String challenge2 = "I want a bike";
        String challenge3 = "I want a ball";
        System.out.println(challenge2.matches(reg));
        System.out.println(challenge3.matches(reg));

        // Challenge 3 - same as challenge 2 except using pattern & matcher classes
        String reg3 = "I want a \\w+";
        Pattern pattern3 = Pattern.compile(reg3);
        Matcher matcher3 = pattern3.matcher(challenge2);
        System.out.println(matcher3.matches());

        matcher3 = pattern3.matcher(challenge3);
        System.out.println(matcher3.matches());

        // Challenge 4 - Replace all blanks with underscore
        String challenge4 = "Replace all blanks with underscore";
        String reg4 = "\\s";
        String rep4 = "_";

        System.out.println(challenge4.replaceAll(reg4,rep4));

        // Challenge 5 - Match a string in its entirety
        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));

        // Challenge 6 - Regular Expression that will only match the challenge 5 string in its entirety.
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$","REPLACED"));

        // Challenge 7 - Regular Expression that will match a string that starts with a series of letter
        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+$"));

        // Challenge 8 - Modify  challenge 7 to use group, so that we can print all the digits that matches the reg.
        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);

        while (matcher8.find()) {
            System.out.println("Occurrence: " + matcher8.group(1));
        }

        // Challenge 9 -
        String challenge9 = "abcd.135\tuvqz.7\tzik.999\n";
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);

        while (matcher9.find()) {
            System.out.println("Occurrence: " + matcher9.group(1));
        }

        // Challenge 10 - Instead of printing no. print start & end from challenge 9
        String challenge10 = "abcd.135\tuvqz.7\tzik.999\n";
        Pattern pattern10 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher10 = pattern10.matcher(challenge10);

        while (matcher10.find()) {
            System.out.println("Occurrence: start: " + matcher10.start(1) + " end: " + (matcher10.end(1) - 1));
        }

        // Challenge 11
        String challenge11 = "{0,2}, {0,5}, {1,3}, {2,4}";
        Pattern pattern11 = Pattern.compile("\\{(.+?)\\}"); //"\\{(\\d+ \\d+)\\}"
        Matcher matcher11 = pattern11.matcher(challenge11);

        while (matcher11.find()) {
            System.out.println("Occurrence: " + matcher11.group(1));
        }

        // Challenge 12 - reg for pincode 11111;
        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));

        // Challenge 13 - reg for pincode 11111-1111;
        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        // Challenge 14 - single reg for challenge 12 & challenge 13
        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})?$"));
    }
}
