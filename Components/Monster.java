import java.util.ArrayList;
import java.util.List;

public class Monster {
    private int id;
    private String nama;
    private List<ElementType> elementTypesList = new ArrayList<ElementType>();
    private Stats baseStats;
    private List<Move> movesList = new ArrayList<Move>();
    private double HP;

    //constructor
    public Monster(int id, String nama, List<ElementType> elementTypesList, Stats baseStats, List<Move> movesList, double HP) {
        this.id = id;
        this.nama = nama;
        this.elementTypesList = elementTypesList;
        this.baseStats = baseStats;
        this.movesList = movesList;
        this.HP = HP;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void addElementType(ElementType elementType) {
        elementTypesList.add(elementType);
    }

    public List<ElementType> getElementTypesList() {
        return this.elementTypesList;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }
    
    public void addMoves(Move move) {
        movesList.add(move);
    }

    public List<Move> getMovesList() {
        return this.movesList;
    }
    public double getHP(){
        return HP;
    }
}
