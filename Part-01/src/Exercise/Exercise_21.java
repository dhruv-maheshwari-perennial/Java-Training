package Exercise;

// Exercise 21 - Carpet Cost Calculator
class Floor {
    public double width, length;

    public Floor(double width, double length) {
        this.width = (width < 0) ? 0 : width;
        this.length = (length < 0) ? 0 : length;
    }

    public double getArea() {
        return (width * length);
    }
}

class Carpet {
    public double cost;

    public Carpet(double cost) {
        this.cost = (cost < 0) ? 0 : cost;
    }

    public double getCost() {
        return cost;
    }
}

class Calculator {
    public Floor floor;
    public Carpet carpet;

    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public double getTotalCost() {
        return floor.getArea() * carpet.getCost();
    }
}

public class Exercise_21 {
    public static void main(String[] args) {
        Carpet carpet = new Carpet(3.5);
        Floor floor = new Floor(2.75,4.0);

        Calculator calculator = new Calculator(floor, carpet);
        System.out.println("Total: " + calculator.getTotalCost());

        Carpet carpet2 = new Carpet(1.5);
        Floor floor2 = new Floor(4.5,5.4);

        Calculator calculator2 = new Calculator(floor2, carpet2);
        System.out.println("Total: " + calculator2.getTotalCost());
    }
}
