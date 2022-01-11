package Exercise;

// Exercise 22 - Cylinder

class Circle {
    public double radius;
    public double PI = Math.PI;

    public Circle(double radius) {
        this.radius = (radius < 0) ? 0 : radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return (getRadius() * getRadius() * PI);
    }
}

class Cylinder extends Circle {
    public double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = (height < 0) ? 0 : height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return (getArea() * height);
    }
}

public class Exercise_22 {
    public static void main(String[] args) {
        Circle circle = new Circle(3.75);

        System.out.println("Circle Radius: " + circle.getRadius());
        System.out.println("Circle Area: " + circle.getArea());

        Cylinder cylinder = new Cylinder(5.55, 7.25);

        System.out.println("Cylinder Radius: " + cylinder.getRadius());
        System.out.println("Cylinder Height: " + cylinder.getHeight());
        System.out.println("Cylinder Area: " + cylinder.getArea());
        System.out.println("Cylinder Volume: " + cylinder.getVolume());
    }
}
