package Exercise;

import java.util.Scanner;

// Exercise 16 - Input Calculator
public class Exercise_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        double sum = 0, count = 0, avg = 0;

        while (true) {
            System.out.print("Enter any number: ");
            boolean isAnInt = sc.hasNextInt();

            if (isAnInt) {
                num = sc.nextInt();
                sum += num;
                count++;
            } else {
                break;
            }
            
            avg = sum / count;
        }

        System.out.println("Sum: " + sum);
        System.out.println("Avg: " + avg);
    }
}
