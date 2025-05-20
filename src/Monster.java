public class Monster extends Entity
{
    Monster(int health, int damageMin, int damageMax) {
        super(health, damageMin, damageMax);
    }
    @Override
    public void entityDead() {
        System.out.println("Monster has died");
    }
}