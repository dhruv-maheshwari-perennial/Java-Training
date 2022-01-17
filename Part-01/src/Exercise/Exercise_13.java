package Exercise;

import java.util.Scanner;

// Exercise 13 - Factors of a number
public class Exercise_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        System.out.print("Enter any number: ");
        number = sc.nextInt();

        printFactors(number);
    }

    public static void printFactors(int number) {

        if (number < 1) {
            System.out.println("Invalid Number");
        } else {
            System.out.print("Factors of " + number + ": ");

            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
