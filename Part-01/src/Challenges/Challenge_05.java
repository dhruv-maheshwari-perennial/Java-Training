package Challenges;

import java.util.Scanner;

// create a method called displayHighScorePosition
public class Challenge_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playerName;
        int score, position;

        System.out.print("Enter Player Name: ");
        playerName = sc.nextLine();
        System.out.print("Enter Player Score: ");
        score = sc.nextInt();

        position = calculateHighScorePosition(score);
        displayHighScorePosition(playerName, position);

    }

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + " manage to get into position " + position + " on the high score table.");
    }

    public static int calculateHighScorePosition(int score) {
        if (score >= 1000) {
            return 1;
        } else if (score >= 500 && score < 1000) {
            return 2;
        } else if (score >= 100 && score < 500) {
            return 3;
        } else {
            return 4;
        }
    }
}
