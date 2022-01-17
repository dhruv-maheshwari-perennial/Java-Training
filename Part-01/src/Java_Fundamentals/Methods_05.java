package Java_Fundamentals;

//import java.util.Scanner;

public class Methods_05 {
    public static void main(String[] args) {
        // for taking input from user
//        Scanner sc = new Scanner(System.in);

//        int bonus = 100;
//        int score, levelCompleted;

//        System.out.print("Enter your score: ");
//        score = sc.nextInt();
//        System.out.print("Enter no. of levels completed: ");
//        levelCompleted = sc.nextInt();
//
//        int finalScore = calculateScore(true, score, levelCompleted, bonus);
//        System.out.println("Total Score: " + finalScore);

        person("Dhruv Maheshwari");
        person(21);
        person(20000.0);

    }

    // method with return statement
//    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
//        int totalScore = 0;
//        if (gameOver) {
//            totalScore = score + (levelCompleted * bonus);
//        }
//        return totalScore;
//    }

    //method overloading
    public static void person(String name){
        System.out.println("Name: " + name);
    }

    public static void person(int age){
        System.out.println("Age: " + age);
    }

    public static void person(double salary){
        System.out.println("Salary: " + salary);
    }
}
