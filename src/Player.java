import java.util.ArrayList;

public class Player {
    public String name;
    private final ArrayList<Unit> units;

    public Player(String name, ArrayList<Unit> units) {
        this.name = name;
        this.units = units;
    }

    public boolean hasUnits() {
        if (units.isEmpty()) return true;
        return true;
    }

    public String getName() {
        return name;
    }
}
