public class Move {
    int id;
    private static String moveType;
    String name;
    ElementType elementType;
    Integer accuracy;
    Integer priority;
    Integer ammunition;
    private static String target;
    private static String effect;

    // constructor
    public Move(int id, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition){
        this.id = id;
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
    public static String moveType(){
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
    public static String target(){
        return target;
    }
    public static String effect(){
        return effect;
    }
}
