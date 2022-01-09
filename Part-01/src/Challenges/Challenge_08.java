package Challenges;

// Sum of 3 & 5
public class Challenge_08 {
    public static void main(String[] args) {
        int count = 0, sum = 0;
        for (int i = 1; i <= 1000; i++) {
            if((i % 3 == 0) && (i % 5 == 0)) {
                count++;
                sum += i;
                System.out.println("Number Found: " + i);
            }
            if(count == 5) {
                break;
            }
        }

        System.out.println("Sum: " + sum);
    }
}
