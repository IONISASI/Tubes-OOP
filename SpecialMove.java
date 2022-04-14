public class SpecialMove extends Move{
    private int basePower; // di config ini dari effect

    //constructor
    public SpecialMove(int id, String moveType, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition, int basePower){
        super(id, moveType, name, elementType, accuracy, priority, ammunition);
        this.basePower = basePower;
    }

    //getter
    public int getBasePower(){
        return this.basePower;
    }
}