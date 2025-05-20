public class Monster extends Entity
{
    Monster(int health, int damageMin, int damageMax, String name) {
        super(health, damageMin, damageMax, name);
    }
    @Override
    public void entityDead() {
        System.out.println(this.name + " has died");
    }
}