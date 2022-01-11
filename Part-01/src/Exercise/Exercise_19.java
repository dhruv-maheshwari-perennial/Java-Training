package Exercise;

// Exercise 19 - Wall Area
class Wall {
    public double width, height;

    // no-agr constructor
    public Wall(){}

    public Wall(double width, double height) {
        this.width = (width < 0) ? 0 : width;
        this.height = (height < 0) ? 0 : height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = (width < 0) ? 0 : width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = (height < 0) ? 0 : height;
    }

    public double getArea() {
        return width * height;
    }
}

public class Exercise_19 {
    public static void main(String[] args) {
        Wall wall = new Wall(5,4);
        System.out.println("Area: " + wall.getArea());

        wall.setHeight(-1.5);
        System.out.println("Width: " + wall.getWidth());
        System.out.println("Height: " + wall.getHeight());
        System.out.println("Area: " + wall.getArea());
    }
}
