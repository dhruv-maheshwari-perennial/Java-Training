package Challenges;

// Seconds and Minutes Challenge
public class Challenge_07 {
    public static void main(String[] args) {
        int minutes = 61;
        int seconds = 40;
        int secSeconds = 40000;

        String result = getDurationString(minutes,seconds);
        System.out.println(result);

        String resultSecond = getDurationString(secSeconds);
        System.out.println(resultSecond);
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes >= 0 && (seconds >= 0 && seconds <= 59)) {
            int hour = minutes / 60;
            int reMin = minutes % 60;

            return hour + "h " + reMin + "m " + seconds + "s";
        }
        return "Invalid Values";
    }

    public static String getDurationString(int secSeconds) {
        if (secSeconds >= 0) {
            int min = secSeconds / 60;
            int remSeconds = secSeconds % 60;

            return getDurationString(min, remSeconds);
        }
        return "Invalid Values";
    }
}
