public class Unit {
    private  String name;
    private int health;

    public Unit() {
        this("Not pikachu", 100);

    }
    public Unit(String name, int health){
        this.name = name;
        this.health = health;
    }

    public Object getType() {
        return null;
    }

    public Player getOwner() {
        return null;
    }

    public Object getHealth() {
        return null;
    }
}
