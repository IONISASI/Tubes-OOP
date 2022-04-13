public class StatusMove extends Move{
    String target;
    String statcon;
    Stats stats;

    //kayanya gini sih

    public StatusMove(int id, String moveType, String name, ElementType elementType, Integer accuracy, Integer priority, Integer ammunition, String target, String statcon, Stats stats){
        super(id, moveType, name, elementType, accuracy, priority, ammunition);
        this.target = target;
        this.statcon = statcon;
        this.stats = stats;
    }

    public String getTarget(){
        return this.target;
    }

    public String getStatcon(){
        return this.statcon;
    }

    public Stats getStats(){
        return this.stats;
    }

}
