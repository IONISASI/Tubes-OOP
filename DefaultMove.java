public class DefaultMove extends Move{
    private int basePower;
    //constructor
    public DefaultMove(int id, String name, int basePower){
        super(id, name, ElementType.valueOf("NORMAL"), 100, 0, Integer.MAX_VALUE);
        this.basePower = basePower;
    }

    //getter
    public int getBasePower(){
        return this.basePower;
    }

    // ntar klo suatu monster pake move ini 
    // health point monster nya bakal ngurangin
    // berikurang 1/4 dari maksimum health (bulat kebawah)
}
