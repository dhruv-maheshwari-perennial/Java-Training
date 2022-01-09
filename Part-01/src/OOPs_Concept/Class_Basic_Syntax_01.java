package OOPs_Concept;

public class Class_Basic_Syntax_01 {
    public static void main(String[] args) {
        // object for class Car
        Car bmw = new Car();

        // accessing Car class variables
        // calling setter method
        bmw.setColour("Red");

        // calling getter method
        System.out.println("BMW is of " + bmw.getColour() + " Color.");
    }
}
