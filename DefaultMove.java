public class DefaultMove extends Move{
    private int basePower;
    //constructor
    public DefaultMove(){
        super(0, "DEFAULT", "DEFAULT", ElementType.valueOf("NORMAL"), 100, 0, Integer.MAX_VALUE);
        this.basePower = 50;
    }

    //getter
    public int getBasePower(){
        return this.basePower;
    }

    // ntar klo suatu monster pake move ini 
    // health point monster nya bakal ngurangin
    // berikurang 1/4 dari maksimum health (bulat kebawah)
}
