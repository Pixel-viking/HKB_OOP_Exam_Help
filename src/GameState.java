import java.util.ArrayList;

public class GameState {
    /*
    private int currentTurn;
    private final ArrayList<Player> players;
    private final ArrayList<Unit> units;

    public GameState(ArrayList<Player> players, ArrayList<Unit> units) {
        this.players = players;
        this.units = units;
        this.currentTurn = 0;
    }

    public Player getCurrentPlayer() {
        return players.get(currentTurn % players.size());
    }

    public void advanceTurn() {
        currentTurn++;
    }

    public boolean isGameOver() {
        long alivePlayers = players.stream()
                .filter(Player::hasUnits)
                .count();
        return alivePlayers <= 1;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

     */
}
