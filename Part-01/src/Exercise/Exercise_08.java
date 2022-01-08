package Exercise;

// Exercise 08 - Area Calculate
public class Exercise_08 {
    public static void main(String[] args) {
        double radius = 5.0, x = 5.0, y = 4.0;

        double resultCircle = area(radius);
        double resultRectangle = area(x, y);

        System.out.println(resultCircle);
        System.out.println(resultRectangle);
    }

    private static double area(double x, double y) {
        if (x < 0 || y < 0) return -1.0;
        return x * y;
    }

    private static double area(double radius) {
        if (radius < 0) return -1.0;
        return 3.14 * radius * radius;
    }
}
