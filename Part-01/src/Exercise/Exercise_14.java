package Exercise;

import java.util.Scanner;

// Exercise 14 - Perfect Number
public class Exercise_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        System.out.print("Enter any number: ");
        number = sc.nextInt();

        boolean result = ifPerfectNumber(number);
        System.out.println(result);
    }

    private static boolean ifPerfectNumber(int number) {
        int sum = 0;

        if (number < 1) {
            return false;
        } else {
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }

            return sum == number;
        }
    }
}
