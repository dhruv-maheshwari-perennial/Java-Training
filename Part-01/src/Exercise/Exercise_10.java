package Exercise;

import java.util.Scanner;

// Exercise 10 - Number In Word
public class Exercise_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.print("Enter any Number(0-9): ");
        num = sc.nextInt();

        printNumberInWord(num);
    }

    public static void printNumberInWord(int num) {
        if (num == 0) System.out.println("ZERO");
        else if (num == 1 || num == -1) System.out.println("ONE");
        else if (num == 2 || num == -2) System.out.println("TWO");
        else if (num == 3 || num == -3) System.out.println("THREE");
        else if (num == 4 || num == -4) System.out.println("FOUR");
        else if (num == 5 || num == -5) System.out.println("FIVE");
        else if (num == 6 || num == -6) System.out.println("SIX");
        else if (num == 7 || num == -7) System.out.println("SEVEN");
        else if (num == 8 || num == -8) System.out.println("EIGHT");
        else if (num == 9 || num == -9) System.out.println("NINE");
        else System.out.println("Number out of range(0-9)");
    }
}
