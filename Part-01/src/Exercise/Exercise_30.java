package Exercise;

import java.util.Scanner;

// Exercise 30 - Reverse Array
public class Exercise_30 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int len = readInteger(); // reading num. of elements given by user
        int[] myArr = readElement(len); // creating array
        reverse(myArr);
    }

    private static void reverse(int[] a) {
        System.out.print("Array = [ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");

        int temp, len = a.length;
        for (int i = 0; i < len / 2; i++) {
            temp = a[i];
            a[i] = a[len - i - 1];
            a[len - i - 1] = temp;
        }

        // printing the reversed array
        System.out.print("Reverse Array = [ ");
        for (int k = 0; k < len; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println("]");

    }

    private static int[] readElement(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Element at " + i + ": ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private static int readInteger() {
        System.out.print("Enter the number of element: ");
        int num = sc.nextInt();
        return num;
    }
}
