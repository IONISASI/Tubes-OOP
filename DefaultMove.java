public class DefaultMove extends Move {
    private static DefaultMove singleInstance = null;
    private int basePower;
  
    //constructor
    public DefaultMove(){
        super(0, "DEFAULT", "Default Move", ElementType.valueOf("NORMAL"), 100, 0, Integer.MAX_VALUE);
        this.basePower = 50;
    }

    //getter
    public int getBasePower(){
        return this.basePower;
    }

    public static DefaultMove getInstance() {
        if (singleInstance == null) {
            singleInstance = new DefaultMove();
        }
 
        return singleInstance;
    }

    // ntar klo suatu monster pake move ini 
    // health point monster nya bakal ngurangin
    // berikurang 1/4 dari maksimum health (bulat kebawah)
}
