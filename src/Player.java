
public class Player extends Entity
{
    Player(int health, int damageMin, int damageMax, String name) {
        super(health, damageMin, damageMax, name);
    }

    @Override
    public void entityDead() {
        System.out.println(this.name + " has died");
        System.out.println("Better luck next time");
    }
}
