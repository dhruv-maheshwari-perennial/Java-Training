package Classes_Interfaces;

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
    public abstract void breathe();

    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
    }

    @Override
    public void breathe() {
        System.out.println("Breath in, breath out, repeat");
    }
}

abstract class Bird extends Animal implements CanFly {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");
    }

    @Override
    public void breathe() {
        System.out.println("Bird - Breath in, breath out, repeat");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " flapping its wing");
    }
}

class Parrot extends Bird {
    public Parrot(String name) {
        super(name);
    }
}

class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("I'm not very good at it.");
    }
}

public class Abstract_Class_03 {
    public static void main(String[] args) {
        Dog dog = new Dog("Puppy");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Regina");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Peg");
        penguin.fly();
    }
}
