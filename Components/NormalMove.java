package Components;

public class NormalMove extends Move{
    private int basePower; // di config ini dari effect

    //constructor
    public NormalMove(int id, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition, int basePower){
        super(id, name, elementType, accuracy, priority, ammunition);
        this.basePower = basePower;
    }

    //getter
    public int getBasePower(){
        return this.basePower;
    }

    
}
