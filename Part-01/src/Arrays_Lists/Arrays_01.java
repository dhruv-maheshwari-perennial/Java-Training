package Arrays_Lists;

public class Arrays_01 {
    public static void main(String[] args) {
        int[] myIntArray = new int[10];

        inputArray(myIntArray);
        printArray(myIntArray);
    }

    private static void printArray(int[] myIntArray) {
        for (int j : myIntArray) {
            System.out.println(j);
        }
    }

    private static void inputArray(int[] myIntArray) {
        for (int i = 0; i < myIntArray.length; i++) {
            myIntArray[i] = i * 10;
        }
    }
}
