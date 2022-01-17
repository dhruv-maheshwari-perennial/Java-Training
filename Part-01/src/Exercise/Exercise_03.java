package Exercise;

// Exercise 03 - Barking Dog
public class Exercise_03 {
    public static void main(String[] args) {
        boolean barking = true;
        int hourOfDay = -1;

        boolean wakeUp = shouldWakeUp(barking, hourOfDay);
        System.out.println(wakeUp);
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23) return false;
        if (barking) {
            if (hourOfDay < 8 || hourOfDay > 22) return true;
        }
        return false;
    }
}
