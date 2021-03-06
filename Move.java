public class Move {
    int id;
    String moveType;
    String name;
    ElementType elementType;
    Integer accuracy;
    Integer priority;
    Integer ammunition;
    String target;
    private static String effect;

    // constructor
    public Move(int id, String moveType, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition){
        this.id = id;
        this.moveType = moveType;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
    }

    //getter
    public int getId(){
        return this.id;
    }
    public String getMoveType(){
        return moveType;
    }
    public String getName(){
        return this.name;
    }
    public ElementType getElementType(){
        return this.elementType;
    }
    public Integer getAccuracy(){
        return this.accuracy;
    }
    public Integer getPriority(){
        return this.priority;
    }
    public Integer getAmmunition(){
        return this.ammunition;
    }
    public String getTarget(){
        return this.target;
    }
  
    public static String effect(){
        return effect;
    }
}