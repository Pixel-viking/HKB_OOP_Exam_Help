import java.util.Random;

public class Unit {
    private  String name;
    private int health;
    private int damage;

    public Unit() {
        this("Not pikachu", 100);

    }
    public Unit(String name, int health){
        this.name = name;
        this.health = health;
        this.damage = 20;
    }

    //#Methods

    public boolean attack(Unit target) {
        Random rand = new Random();

        if (rand.nextInt() % 100 < 25)
            return false;

        target.takeDamage(this.damage);

        return true;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    //# Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //# Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
