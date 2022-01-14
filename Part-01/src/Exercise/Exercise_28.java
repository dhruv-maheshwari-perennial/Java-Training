package Exercise;

import java.util.Scanner;

// Exercise 28 - Sorted Array
public class Exercise_28 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Get Integers --> ");
        int[] myArr = getInteger(5);

        System.out.println("Print Sorted Array --> ");
        int[] sortArr = sortArray(myArr);
        printSortedArray(sortArr);
    }

    private static void printSortedArray(int[] sortArr) {
        for (int i = 0; i < sortArr.length; i++) {
            System.out.println("Element " + i + " contents " + sortArr[i]);
        }
    }

    private static int[] sortArray(int[] myArr) {
        int[] arr = new int[myArr.length];
        int temp;
        boolean sorted = false;

        for (int i = 0; i < myArr.length; i++) {
            arr[i] = myArr[i];
        }

        while (sorted == false) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                    sorted = false;
                }
            }
        }
        return arr;
    }

    private static int[] getInteger(int i) {
        int[] nums = new int[i];
        for (int j = 0; j < nums.length; j++) {
            System.out.print("Element at " + j + ": ");
            nums[j] = sc.nextInt();
        }

        return nums;
    }


}
