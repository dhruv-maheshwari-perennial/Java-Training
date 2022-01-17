package Exercise;

// Exercise 27 - Bill's Burgers
class Hamburger {
    public String name, meat, breadRollType;
    public String addition1Name, addition2Name, addition3Name, addition4Name;
    public double addition1Price = 0.0, addition2Price = 0.0, addition3Price = 0.0, addition4Price = 0.0;
    public double price;

    public Hamburger(String name, String meat, String breadRollType, double price) {
        this.name = name;
        this.meat = meat;
        this.breadRollType = breadRollType;
        this.price = price;
        System.out.println(this.name + " hamburger on a " + this.breadRollType + " roll with " + this.meat + ", price is " + this.price);
    }

    public void addHamburgerAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1Price = price;

        System.out.println("Added " + this.addition1Name + " for an extra " + this.addition1Price);
    }
    public void addHamburgerAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2Price = price;

        System.out.println("Added " + this.addition2Name + " for an extra " + this.addition2Price);
    }
    public void addHamburgerAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3Price = price;

        System.out.println("Added " + this.addition3Name + " for an extra " + this.addition3Price);
    }
    public void addHamburgerAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4Price = price;

        System.out.println("Added " + this.addition4Name + " for an extra " + this.addition4Price);
    }

    public double itemizehamburger() {
        return price + this.addition1Price + this.addition2Price + this.addition3Price;
    }
}

public class Exercise_27 {
    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic", "Sausage", "White", 3.56);
        hamburger.addHamburgerAddition1("Tomato",0.27);
        hamburger.addHamburgerAddition2("Lettuce",0.75);
        hamburger.addHamburgerAddition3("Cheese",1.13);
        System.out.println("Total Burger Price: " + hamburger.itemizehamburger());
    }
}
