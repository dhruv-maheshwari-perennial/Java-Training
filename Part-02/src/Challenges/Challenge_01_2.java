package Challenges;

import java.util.function.Function;
import java.util.function.Supplier;

public class Challenge_01_2 {
    public static void main(String[] args) {

        // Challenge 1
        Runnable r1 = () -> {
          String myString = "Let's Split Up";
          String[] parts = myString.split(" ");

          for (String part: parts) {
              System.out.println(part);
          }
        };

        // Challenge 2
        Function<String, String> chl2 = s -> {
            StringBuilder returnValue = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnValue.append(s.charAt(i));
                }
            }

            return returnValue.toString();
        };

        // Challenge 3
        System.out.println(chl2.apply("1234567890"));

        // Challenge 5
        String result = everySecondChar(chl2, "1234567890");
        System.out.println(result);

        // Challenge 6
        Supplier<String> iLoveJava = () -> {
            return "I Love Java";
        };

        // Challenge 7
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }

    // Challenge 4
    public static String everySecondChar(Function<String, String> func, String source) {
        return func.apply(source);
    }
}
