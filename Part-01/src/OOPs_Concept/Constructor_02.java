package OOPs_Concept;


class ABC {
    public String name;

    // default constructor
    public ABC() {
        System.out.println("Default Constructor");
    }

    // parameterized constructor
    public ABC(String name) {
        System.out.println("Parameterize Constructor - " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Constructor_02 {
    public static void main(String[] args) {
        ABC abc = new ABC(); // default constructor calling
        abc.setName("Dhruv");
        new ABC(abc.getName()); // parameterize constructor calling
    }
}
