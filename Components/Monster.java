import java.util.ArrayList;
import java.util.List;

public class Monster {
    private int id;
    private String nama;
    private List<ElementType> elementTypesList = new ArrayList<ElementType>();
    private Stats baseStats;
    private List<Move> movesList = new ArrayList<Move>();

    //constructor
    public Monster(int id, String nama, List<ElementType> elementTypesList, Stats baseStats, List<Move> movesList) {
        this.id = id;
        this.nama = nama;
        this.elementTypesList = elementTypesList;
        this.baseStats = baseStats;
        this.movesList = movesList;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void addElementType(ElementType elementType) {
        elementTypeList.add(elementType);
    }

    public List<ElementType> getElementTypesList() {
        return this.elementTypesList;
    }

    public String getBaseStats() {
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
}
