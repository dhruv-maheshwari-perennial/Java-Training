package Exercise;

// Exercise 05 - Decimal Comparator
public class Exercise_05 {
    public static void main(String[] args) {
        double num1 = -3.1756;
        double num2 = -3.175;

        boolean equal = areEqualByThreeDecimalPlaces(num1,num2);
        System.out.println(equal);
    }

    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        if(num1 == num2) return true;
        return false;
    }
}
