package Java_Fundamentals;

import java.util.Scanner;

public class Methods_05 {
    public static void main(String[] args) {
        // for taking input from user
        Scanner sc = new Scanner(System.in);

        int bonus = 100;
        int score, levelCompleted;

        System.out.print("Enter your score: ");
        score = sc.nextInt();
        System.out.print("Enter no. of levels completed: ");
        levelCompleted = sc.nextInt();

        int finalScore = calculateScore(true, score, levelCompleted, bonus);
        System.out.println("Total Score: " + finalScore);
    }

    // method with return statement
    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        int totalScore = 0;
        if (gameOver) {
            totalScore = score + (levelCompleted * bonus);
//            System.out.println("Total Score: " + totalScore);
        }
//        else {
//            System.out.println("Game not finished yet.");
//        }
        return totalScore;
    }
}
