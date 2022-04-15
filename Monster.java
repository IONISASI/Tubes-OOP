import java.util.ArrayList;
import java.util.List;

public class Monster extends Stats {
    private int id;
    private String nama;
    private List<ElementType> elementTypesList = new ArrayList<ElementType>();
    private List<Move> movesList = new ArrayList<Move>();
    private String statusCon;
    private double maxHP;
    private int skipTurn = 0;

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

    public int getSkipTurn(){
        return this.skipTurn;
    }

    public void setSkipTurn(int st){
        this.skipTurn = st;
    }

    public Double getMaxHP(){
        return this.maxHP;
    }

    public void applyEffect(Stats stat) {
      this.setHP(this.getHP() + stat.getHP());
      if (this.getHP() > this.getMaxHP()) {
        this.setHP(this.getMaxHP());
      }
      this.setAtt(this.getAtt() + stat.getAtt());
      this.setDef(this.getDef() + stat.getDef());
      this.setspatt(this.getspatt() + stat.getspatt());
      this.setspdef(this.getspdef() + stat.getspdef());
      this.setspeed(this.getspeed() + stat.getspeed());
    }
}