package Exercise;

import java.util.Scanner;

// Exercise 02 - MegaByte Convertor
public class Exercise_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kiloByte;

        System.out.print("Enter KiloByte: ");
        kiloByte = sc.nextInt();

        // 1Mb = 1024Kb

        printMegaBytesAndKiloBytes(kiloByte);
    }

    public static void printMegaBytesAndKiloBytes(int kiloByte) {
        int MegaBytes = kiloByte / 1024;
        int remKiloBytes = kiloByte % 1024;

        if (kiloByte < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kiloByte + " KB = " + MegaBytes + " MB and " + remKiloBytes + " KB");
        }
    }
}
