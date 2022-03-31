public class Monster {
    private int id;
    private String nama;
    private List<ElementType> elementTypesList = new ArrayList<ElementType>();
    private Stats baseStats;
    private List<Move> movesList = new ArrayList<Move>();
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void addElementType(ElementType elementType) {
        // Tambahkan citizenship ke list, gunakan metode add dari java.util.List
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