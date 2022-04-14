import java.util.ArrayList;
import java.util.List;

public class Monster extends Stats {
    private int id;
    private String nama;
    private List<ElementType> elementTypesList = new ArrayList<ElementType>();
    private List<Move> movesList = new ArrayList<Move>();
    private String statusCon;
    private double maxHP;

    //constructor
    public Monster(int id, String nama, List<ElementType> elementTypesList, Stats someBaseStats, List<Move> movesList) {
        super(someBaseStats.getHP(), someBaseStats.getAtt(), someBaseStats.getDef(), someBaseStats.getspatt(), someBaseStats.getspdef(), someBaseStats.getspeed());
        this.id = id;
        this.nama = nama;
        this.elementTypesList = elementTypesList;
        this.movesList = movesList;
        this.statusCon = "NULL";
        this.maxHP = someBaseStats.getHP();
    }
    
    public Monster(int id, String nama, List<ElementType> elementTypesList, double someHP, double someAtt, double someDef, double someSpatt, double someSpdef, double someSpeed, List<Move> movesList) {
        super(someHP, someAtt, someDef, someSpatt, someSpdef, someSpeed);
        this.id = id;
        this.nama = nama;
        this.elementTypesList = elementTypesList;
        this.movesList = movesList;
        this.statusCon = "NULL";
        this.maxHP = someHP;
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
    
    public void addMoves(Move move) {
        movesList.add(move);
    }

    public List<Move> getMovesList() {
        return this.movesList;
    }

    public String getStatuscon(){
        return this.statusCon;
    }

    public void setStatuscon(String sc){
        this.statusCon = sc;
    }

    public Double getMaxHP(){
        return this.maxHP;
    }
}