package Challenges;

// create a method calcFeetAndInchesToCentimeters
public class Challenge_06 {
    public static void main(String[] args) {
        int feet = 2;
        int inches = 11;
        int secInches = 35;

        double result = calcFeetAndInchesToCentimeters(feet,inches);
        System.out.println(result);

        double secResult = calcFeetAndInchesToCentimeters(secInches);
        System.out.println(secResult);
    }

    public static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        if (feet >= 0 && inches >=0 && inches <= 12) {
            return ((feet * 12) + inches) * 2.54;
        };
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(int secInches) {
        if (secInches >= 0) {
            int feets = secInches / 12;
            int remInches = secInches % 12;

            return calcFeetAndInchesToCentimeters(feets, remInches);
        }
        return -1;
    }
}
