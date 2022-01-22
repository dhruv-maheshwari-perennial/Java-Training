package Challenges;

// Challenge - Inheritance
class Vehicle {
    private String name, size;
    private int currentVelocity, currentDirection;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;
        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("Steering at " + currentDirection + " degrees");
    }

    public void move(int velocity, int direction) {
        currentDirection = direction;
        currentVelocity = velocity;
        System.out.println("Moving at " + currentVelocity + " in direction " + currentDirection);
    }

    public void stop() {
        this.currentVelocity = 0;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
}

class Car extends Vehicle {
    private int wheels, doors, gears, currentGear;
    private boolean isManual;

    public Car(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.currentGear = 1;
        this.isManual = isManual;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Changed to " + this.currentGear + " gear.");
    }

    public void changeVelocity(int speed, int direction) {
        move(speed, direction);
        System.out.println("Velocity: " + speed + " | Direction: " + direction);
    }
}

class BMW extends Car {
    private int roadServiceMonths;

    public BMW(int roadServiceMonths) {
        super("BMW", "4WD", 4, 4, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }

    public void accelerate(int rate) {
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity == 0) {stop(); setCurrentGear(1);}
        else if (newVelocity > 0 && newVelocity <= 10) setCurrentGear(1);
        else if (newVelocity > 10 && newVelocity <= 20) setCurrentGear(2);
        else if (newVelocity > 20 && newVelocity <= 30) setCurrentGear(3);
        else setCurrentGear(4);

        if (newVelocity > 0) changeVelocity(newVelocity, getCurrentDirection());
    }
}

public class Challenge_11 {
    public static void main(String[] args) {
        BMW bmw = new BMW(55);
        bmw.steer(45);
        bmw.accelerate(30);
        bmw.accelerate(50);
    }
}
