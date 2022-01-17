package Challenges;

import java.util.Scanner;

// Digit Sum Challenge
public class Challenge_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        System.out.print("Enter any number: ");
        number = sc.nextInt();

        int result = sumDigits(number);
        System.out.println(result);
    }

    public static int sumDigits(int number) {
        int k, sum = 0;
        if (number < 10) return -1;
        while (number != 0) {
            k = number % 10;
            sum += k;
            number = number / 10;
        }
        return sum;
    }
}
