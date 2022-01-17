package Exercise;

// Exercise 09 - Minutes To Years & Days Calculator
public class Exercise_09 {
    public static void main(String[] args) {
        long minutes = 525600;

        printYearsAndDays(minutes);
    }

    private static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        }

        long years = minutes / 525600;
        long days = (minutes % 525600) / 1440;

        System.out.println(minutes + "min = " + years + "y and " + days + "d");
    }
}
