package OOPs_Concept;

class Player {
    public String fullName, weapon;
    public int health;

    public void loseHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println("Killed");
        }
    }

    public int remHealth() {
        return this.health;
    }
}
public class Encapsulation_04 {
    public static void main(String[] args) {
        Player ply = new Player();
        ply.fullName = "Tim";
        ply.health = 20;
        ply.weapon = "Sword";

        int damage = 10;
        ply.loseHealth(damage);
        System.out.println("Remaining Health = " + ply.remHealth());

        damage = 11;
        ply.health = 100;
        ply.loseHealth(damage);
        System.out.println("Remaining Health = " + ply.remHealth());
    }
}
