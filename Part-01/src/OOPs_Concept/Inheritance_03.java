package OOPs_Concept;

class Animal {
    private String name, category;
    private int size, weight;

    public Animal(String name, String category, int size, int weight) {
        this.name = name;
        this.category = category;
        this.size = size;
        this.weight = weight;
    }

    public void eat() {
        System.out.println("Animal.eat() called");
    }

    public void move(int speed) {
        System.out.println("Animal moving at a speed of " + speed);
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
}

class Dog extends Animal {
    private int eyes;
    private int legs;
    private int tails;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tails, int teeth, String coat) {
        super(name, "Land Animal", size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tails = tails;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog.chew() called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }

    public void run() {
        System.out.println("Dog.run() called");
        move(10);
    }

    public void walk() {
        System.out.println("Dog.walk() called");
        move(5);
    }
}

public class Inheritance_03 {
    public static void main(String[] args) {
        Animal animal = new Animal("Animal", "Animal", 1, 1);
        Dog dog = new Dog("Husky", 1, 1, 2, 4, 1, 10, "Yes");

        dog.eat();
        dog.walk();
        dog.run();
    }
}
