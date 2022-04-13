public class NormalMove extends Move{
    private Integer basePower; // di config ini dari effect

    //constructor
    public NormalMove(int id, String moveType, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition, Integer basePower){
        super(id, moveType, name, elementType, accuracy, priority, ammunition);
        this.basePower = basePower;
    }

    //getter
    public int getBasePower(){
        return this.basePower;
    }

    
}
