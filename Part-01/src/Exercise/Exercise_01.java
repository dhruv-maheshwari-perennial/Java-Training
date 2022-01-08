package Exercise;

import java.util.Scanner;

// Exercise 01 - Speed Convertor
public class Exercise_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double kilometerPerHour;

        System.out.print("Enter Kilometer/Hour: ");
        kilometerPerHour = sc.nextDouble();

        // 1Km/Hr = 0.6214Miles/Hr

        long milesPerHour = toMilesPerHour(kilometerPerHour);
        System.out.println(milesPerHour);
        printConversion(kilometerPerHour);
    }

    public static void printConversion(double kilometerPerHour) {
        long milesPerHour = toMilesPerHour(kilometerPerHour);
        if (milesPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometerPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }

    public static long toMilesPerHour(double kilometerPerHour) {
        long speed = Math.round(kilometerPerHour * 0.6214);

        if (speed < 0) return -1;
        return speed;
    }
}
