package Exercise;

// Exercise 12 - Palindrome Number
public class Exercise_12 {
    public static void main(String[] args) {
        int number = 11212;
        boolean result = isPalindrome(number);
        System.out.println(result);
    }

    public static boolean isPalindrome(int number) {
        int k, reverse = 0, num = number;

        while (number != 0) {
            k = number % 10;
            reverse = (reverse * 10) + k;
            number = number / 10;
        }

        if (reverse == num) return true;
        else return false;
    }
}
