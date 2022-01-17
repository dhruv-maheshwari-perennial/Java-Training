package Exercise;

// Exercise 07 - Teen Number Checker
public class Exercise_07 {
    public static void main(String[] args) {
        int num1 = 9, num2 = 99, num3 = 19;
        boolean equalHasTeen = hasTeen(num1,num2,num3);
        System.out.println(equalHasTeen);

        boolean equalIsTeen = isTeen(num1);
        System.out.println(equalIsTeen);
    }

    public static boolean isTeen(int num1) {
        if(num1 >= 13 && num1 <= 19) return true;
        return false;
    }

    public static boolean hasTeen(int num1, int num2, int num3) {
        if(num1 >= 13 && num1 <= 19) {
            return true;
        } else if (num2 >= 13 && num2 <= 19) {
            return true;
        } else if (num3 >= 13 && num3 <= 19) {
            return true;
        } else {
            return false;
        }
    }
}
