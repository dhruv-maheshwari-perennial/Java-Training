package Exercise;

// Exercise 06 - Equal Sum Checker
public class Exercise_06 {
    public static void main(String[] args) {
        int num1 = 1, num2 = 1, num3 = 1;
        boolean equal = hasEqualSum(num1,num2,num3);
        System.out.println(equal);
    }

    public static boolean hasEqualSum(int num1, int num2, int num3) {
        if((num1 + num2) == num3) return true;
        return false;
    }
}
