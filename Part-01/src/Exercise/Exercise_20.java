package Exercise;

// Exercise 20 - Point
class Point {
    public int x, y;

    // no-agr constructor
    public Point(){}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        int a = 0, b = 0;
        double result = Math.sqrt(((a - getX()) * (a - getX())) + ((b - getY()) * (b - getY())));
        return result;
    }

    public double distance(int a, int b) {
        double result = Math.sqrt(((a - getX()) * (a - getX())) + ((b - getY()) * (b - getY())));
        return result;
    }
}

public class Exercise_20 {
    public static void main(String[] args) {
        Point first = new Point(6, 5);
        Point second = new Point(3,1);

        System.out.println("Distance(0,0): " + first.distance());
        System.out.println("Distance(second): " + first.distance(second.x, second.y));
        System.out.println("Distance(2,2): " + first.distance(2,2));

        Point point = new Point();
        System.out.println("Distance(): " + point.distance());
    }
}
