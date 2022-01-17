package Exercise;

import java.util.ArrayList;
import java.util.List;

// Exercise 34 - Interface
class Player implements ISaveable {
    private String name, weapon;
    private int hitPoints, strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);

        values.add(1, "" + this.weapon);
        values.add(1, "" + this.hitPoints);
        values.add(1, "" + this.strength);

        return values;
    }

    @Override
    public void read(List<String> values) {
        if (values != null && values.size() > 0) {
            this.name = values.get(0);
            this.weapon = values.get(3);
            this.hitPoints = Integer.parseInt(values.get(1));
            this.strength = Integer.parseInt(values.get(2));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}

class Monster implements ISaveable {
    private String name;
    private int hitPoints, strength;

    // Constructor
    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Monster [name=" + name +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength + "]";
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, "" + this.hitPoints);
        values.add(2, "" + this.strength);

        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() > 0) {
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
        }
    }

}

public class Exercise_34 {
    public static void main(String[] args) {
        Player person = new Player("Abdeladhim", 10, 100);
        person.toString();
        saveObject(person);
        loadObject(person);

        Monster monster = new Monster("Hulk", 50, 1000);
        monster.toString();
        saveObject(monster);
        loadObject(monster);
    }

    public static void saveObject(ISaveable objectToSave) {
        System.out.println("/*--- Saving ---*/");
        for(int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to the storage device ...");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        System.out.println("/*--- Loading ---*/");
        List<String> values = objectToLoad.write();
        objectToLoad.read(values);
    }
}
