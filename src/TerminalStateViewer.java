import java.util.Scanner;

public class TerminalStateViewer {
    private GameState gameState;
    private final Scanner scanner = new Scanner(System.in);

    public void run(){
        while (!gameState.isGameOver()) {
            displayState();
            System.out.print("Press Enter to advance turn...");
            scanner.nextLine();
            gameState.advanceTurn();
        }
        displayState();
        System.out.println("Game over! Winner: " + gameState.getCurrentPlayer().getName());
    }

    private void displayState() {
        System.out.println("Turn: " + gameState.getCurrentTurn()
                + " | Player: " + gameState.getCurrentPlayer().getName());
        System.out.println("Units:");
        for (Unit u : gameState.getUnits()) {
            System.out.printf("- %s (Owner: %s, HP: %h)",
                    u.getType(),
                    u.getOwner().getName(),
                    u.getHealth());
        }
        System.out.println();
    }

}
