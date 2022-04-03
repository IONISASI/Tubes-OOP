import java.util.*; 
public class Damage extends Monster implements Statcon{
    private static Monster monster1;
    private static Monster monster2;
    public Damage(int id, String nama, List<ElementType> elementTypesList, Stats baseStats, List<Move> movesList, double HP){
        super(id, nama, elementTypesList, baseStats, movesList, HP);
    }
    public void burn(double HP, double att){
        HP = HP*1/8; att = att*1/2;
    }
    public static void burnHP(double HP){
        HP = HP*1/8;
    }
    public static boolean isburn(){
        if()
    }
    public void poison(double HP){
        HP = 1/16*HP;
    }
    public void sleep(int x){
        x = (int) (Math.random() * 7) + 1;
        Battle.skipturn(x);
    }
    public void paralyze(double speed, int y){
        speed = speed*1/2;
        y = new Random().nextInt(4);
        if(y==2){
            Battle.skipturn(1);
        }
    }
    public static double calculateDamage(){
        if(monster1.getbasestats()){
            return ((Double) java.lang.Math.floor((NormalMove.getBasePower()*(monster1.att/monster2.def)+2)*Math.random() * 0.15 * effectivity * 0.5));
        }
        else if(Battle.getturn()==0){
            return ((Double) java.lang.Math.floor((power*(monster1.att/monster2.def)+2)*Math.random() * 0.15 * effectivity * 1));
        }
        else if(Battle.getturn()==1 && monster2.burn()){
            return ((Double) java.lang.Math.floor((power*(monster2.att/monster1.def)+2)*Math.random() * 0.15 * effectivity * 0.5));
        }
        else{
            return ((Double) java.lang.Math.floor((power*(monster1.att/monster2.def)+2)*Math.random() * 0.15 * effectivity * 1));
        }
    }
    public static double aftercalculateDamage(double HP){
        if(monster1.burn()){
            return (Double) java.lang.Math.floor(monster1.burn(HP));
        }
        else if(monster1.poison()){
            return (Double) java.lang.Math.floor(monster1.poison(HP));
        }
        else if(monster2.burn()){
            return (Double) java.lang.Math.floor(monster2.burn(HP));
        }
        else {
            return (Double) java.lang.Math.floor(monster2.poison(HP));
        }
    }
    public static void aftereffect(){
        if(monster1.getHP()==0){
            monster1.switchmonster();
        }
        else{
            monster2.switchmonster();
        }
    }
}
