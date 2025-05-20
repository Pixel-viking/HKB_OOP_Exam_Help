import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        Player player = new Player(100, 8, 16, "Guy with red hat");

        ArrayList<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster(20, 2, 5, "Fire birdy"));
        monsters.add(new Monster(35, 4, 9, "Electric rat"));
        monsters.add(new Boss(64, 7, 15, "Boss man"));

        Game game = new Game(player, monsters);

        game.start();
    }
}