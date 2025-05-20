public class Battle
{
    //# Fields
    private final Player player;
    private Monster monster;

    //# Constructors
    Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }


    //# Getter-methods
    Player getPlayer() {
        return this.player;
    }

    Monster getCurrentMonster() {
        return this.monster;
    }

    //# Setters
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    //# Methods
    public void runBattle() {
        while (true) {
            int playerDamage = this.getPlayer().getDamage();
            int monsterDamage = this.getCurrentMonster().getDamage();
            System.out.println("Player did " + playerDamage + " to Monster");
            if (this.getCurrentMonster().damage(playerDamage)) {
                this.getCurrentMonster().entityDead();
                break;
            }

            System.out.println("Monster did " + playerDamage + " to Player");
            if (this.getPlayer().damage(monsterDamage)) {
                this.getPlayer().entityDead();
                break;
            }
        }
        System.out.println("Battle over");
    }

}
