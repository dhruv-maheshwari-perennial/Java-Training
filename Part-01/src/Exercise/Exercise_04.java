package Exercise;

import java.util.Scanner;

// Exercise 04 - Leap Year Calculate
public class Exercise_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year;

        System.out.print("Enter Year: ");
        year = sc.nextInt();

        boolean leapYear = isLeapYear(year);
        System.out.println(leapYear);
    }

    public static boolean isLeapYear(int year) {
        if(year >= 1 && year < 9999) {
            if (year % 4 == 0 || year % 100 == 0 || year % 400 == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
