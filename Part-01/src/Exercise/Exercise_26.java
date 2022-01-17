package Exercise;

// Exercise 26 - Polymorphism
class Car {
    private boolean engine = true;
    private int cylinders, wheels = 4;
    private String name;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
    }

    public String startEngine() {
        return "Car engine is Starting";
    }

    public String accelerate() {
        return "Car is Accelerating";
    }

    public String brake() {
        return "Car is Braking";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}

class Mitsubishi extends Car {
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi Car engine is Starting";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi Car is Accelerating";
    }

    @Override
    public String brake() {
        return "Mitsubishi Car is Braking";
    }
}

class Holden extends Car {
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Holden Car engine is Starting";
    }

    @Override
    public String accelerate() {
        return "Holden Car is Accelerating";
    }

    @Override
    public String brake() {
        return "Holden Car is Braking";
    }
}

class Ford extends Car {
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Ford Car engine is Starting";
    }

    @Override
    public String accelerate() {
        return "Ford Car is Accelerating";
    }

    @Override
    public String brake() {
        return "Ford Car is Braking";
    }
}

public class Exercise_26 {
    public static void main(String[] args) {
        Car car = new Car(8, "Base Car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        System.out.println("===============================");
        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        System.out.println("===============================");
        Ford ford = new Ford(6, "Ford Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        System.out.println("===============================");
        Holden holden = new Holden(6, "Holden Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
    }
}
