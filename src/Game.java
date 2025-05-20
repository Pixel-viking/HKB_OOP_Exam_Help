import java.util.ArrayList;
import java.util.Random;

public class Game
{
    //# Fields
    private final ArrayList<Monster> monsters;
    private final Battle battle;


    //# Constructors
    Game(Player player, ArrayList<Monster> monsters) {
        this.monsters = monsters;
        this.battle = new Battle(player, monsters.getFirst());
    }


    void start() {
        do {
            battle.setMonster(monsters.getFirst());
            battle.runBattle();
            if (battle.getCurrentMonster().isDead()) {
                monsters.remove(0);
            }
        } while (this.getMonstersLeft() > 0 && !this.getPlayer().isDead());
    }



    //# Getter-methods
    ArrayList<Monster> getMonsters() {
        return this.monsters;
    }

    Battle getBattle() {
        return this.battle;
    }

    Player getPlayer() {
        return this.getBattle().getPlayer();
    }

    int getMonstersLeft() {
        return this.getMonsters().size();
    }


    //# Static-methods
    static int getRandomDamage(int max) {
        return Game.getRandomDamage(0, max);
    }

    static int getRandomDamage(int min, int max) {
        Random RNG = new Random();

        return RNG.nextInt(max - min) + min;
    }
}