package Exercise;

import java.util.Scanner;

// Exercise 29 - Minimum Element
public class Exercise_29 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int len = readInteger(); // reading num. of elements given by user
        int[] myArr = readElement(len); // creating array
        int min = findMin(myArr);

        System.out.println("Minimum Number in Array: " + min);
    }

    private static int findMin(int[] myArr) {
        int minimum = myArr[0];

        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] < minimum) {
                minimum = myArr[i];
            }
        }

        return minimum;
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
