package Components;

public class StatusMove extends Move{
    String statcon;
    double HP;

    public StatusMove(int id, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition, String statcon, double HP){
        super(id, name, elementType, accuracy, priority, ammunition);
        this.statcon = statcon;
        this.HP = HP;
    }

    //ini masih bingung
}
