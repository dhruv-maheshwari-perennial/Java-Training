package Regular_Exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_01 {
    public static void main(String[] args) {
        String myString = "I am a String. Yes, I am";
        System.out.println(myString);

        String youString = myString.replaceAll("I","You");
        System.out.println(youString);

        String alphaNumeric = "davbdsDDDEfefsvsd998";
        System.out.println(alphaNumeric.replaceAll(".","Y"));
        System.out.println(alphaNumeric.replaceAll("^davbds","YYY")); // ^aaa -> change first occurrence (^ - boundary match up first)
        System.out.println(alphaNumeric.matches("^hello"));
        System.out.println(alphaNumeric.replaceAll("sd998$", "YYY")); // sd998$ -> change last occurrence ($ - boundary match up last)
        System.out.println(alphaNumeric.replaceAll("[dvs]", "X")); // [def] -> changes all the letters in the occurrence
        System.out.println(alphaNumeric.replaceAll("[dve][af]","C"));

        System.out.println("harry".replaceAll("[Hh]arry", "Carry"));

        String newAlphaNumeric = "davbdsDDDEfefsvsd998";
        System.out.println(newAlphaNumeric.replaceAll("[^dv]","X"));
        System.out.println(newAlphaNumeric.replaceAll("[abcdef123456]","X"));
        System.out.println(newAlphaNumeric.replaceAll("[a-f1-6]","X")); // 1-6 -> range from 1 to 6
        System.out.println(newAlphaNumeric.replaceAll("[a-fA-F1-6]","X"));
        System.out.println(newAlphaNumeric.replaceAll("(?i)[a-f1-6]","X")); // (?i) -> construct from removing case-sensitivity
        System.out.println(newAlphaNumeric.replaceAll("[0-9]","X"));
        System.out.println(newAlphaNumeric.replaceAll("\\d","X")); // "\\d" -> shortcut method for removing or changing digits
        System.out.println(newAlphaNumeric.replaceAll("\\D","X")); // "\\D" -> shortcut method for removing or changing non-digits

        String hasWhitespace = "I have blanks and\t a tab, and also a newLine\n";
        System.out.println(hasWhitespace);
        System.out.println(hasWhitespace.replaceAll("\\s", "")); // "\\s" -> construct for removing spaces
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        System.out.println(hasWhitespace.replaceAll("\\S", "")); // "\\s" -> construct for removing non-spaces
        System.out.println(newAlphaNumeric.replaceAll("\\w","X")); // "\\w" -> construct for removing or changing [a-z][A-Z][0-9][_]

        System.out.println(hasWhitespace.replaceAll("\\b","X")); // "\\b" -> surround each word with the given string

        // quantifier
        String thirdAlphanumeric = "daveeebdshiiiijEfefsvsd998";
        System.out.println(thirdAlphanumeric.replaceAll("^dave{3}","YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^dave+","YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^dave*","YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^dave{2,5}","YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("h+i*j","Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-Text Heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summery.</p>");

        // Pattern & Matcher Classes
        String h2Pattern = "(<h2>)";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>)(.+?)(</h2>)"; // ? -> lazy quantifier
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(2));
        }

        // and, or & not
        System.out.println("harry".replaceAll("[h|H]arry","Carry"));
        System.out.println("Harry".replaceAll("[h|H]arry","Carry"));

        // [^abc]
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tPattern = Pattern.compile(tNotVRegExp);
        Matcher tMatcher = tPattern.matcher(tvTest);

        count = 0;
        while (tMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tMatcher.start() + " to " + tMatcher.end());
        }

        // US Phone number regress expression
        String reg = "^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$";
        String phone1 = "1234567890";
        String phone2 = "(123) 456-7890";
        String phone3 = "123 456-7890";
        String phone4 = "(123)456-7890";

        System.out.println("Phone 1: " + phone1.matches(reg));
        System.out.println("Phone 2: " + phone2.matches(reg));
        System.out.println("Phone 3: " + phone3.matches(reg));
        System.out.println("Phone 4: " + phone4.matches(reg));

    }
}













