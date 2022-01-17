package Exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exception_02 {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
            System.out.println("unable to perform");
        }
    }

    // multiple catch exceptions
    private static int divide() {
        int x = 0, y = 0;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x: " + x + " | " + "y: " + y);
            return x / y;
        } catch (NoSuchElementException e) {
            throw new ArithmeticException("no suitable input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Divide by zero");
        }
    }

    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter an integer: ");

        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Please enter number using digits: ");
            }
        }
    }
}
