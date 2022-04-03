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
    public static double burnHP(double HP){
        HP = HP*1/8;
        return HP;
    }
    public void poison(double HP){
        HP = 1/16*HP;
    }
    public static double poisoned(double HP){
        HP = 1/16*HP;
        return HP;
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
    public static void calculateDamage(){
        if(Move.effect().contains("BURN") && Move.moveType().contains("NORMAL")){
            System.out.println(java.lang.Math.floor((NormalMove.getBasePower()*(Stats.getAtt()/Stats.getDef())+2)*Math.random() * 0.15 * Effectivity.getEffectivity() * 0.5));
        }
        else if(Move.effect().contains("BURN") && Move.moveType().contains("SPECIAL")){
            System.out.println(java.lang.Math.floor((SpecialMove.getBasePower()*(Stats.getspatt()/Stats.getspdef())+2)*Math.random() * 0.15 * Effectivity.getEffectivity() * 0.5));
        }
        else if(Move.moveType().contains("SPECIAL")){
            System.out.println(java.lang.Math.floor((SpecialMove.getBasePower()*(Stats.getspatt()/Stats.getspdef())+2)*Math.random() * 0.15 * Effectivity.getEffectivity() * 1));
        }
        else if(Move.moveType().contains("NORMAL")){
            System.out.println(java.lang.Math.floor((NormalMove.getBasePower()*(Stats.getAtt()/Stats.getDef())+2)*Math.random() * 0.15 * Effectivity.getEffectivity() * 1));
        }
    }
    public static void aftercalculateDamage(){
        if(Move.effect().contains("BURN") && Move.target().contains("OWN")){
            System.out.println(java.lang.Math.floor(burnHP(monster1.getHP())));
        }
        else if(Move.effect().contains("POISON")&& Move.target().contains("OWN")){
            System.out.println(java.lang.Math.floor(poisoned(monster1.getHP())));
        }
        else if(Move.effect().contains("BURN") && Move.target().contains("ENEMY")){
            System.out.println(java.lang.Math.floor(burnHP(monster2.getHP())));
        }
        else if(Move.effect().contains("POISON") && Move.target().contains("ENEMY")){
            System.out.println(java.lang.Math.floor(poisoned(monster2.getHP())));
        }
    }
    public static void aftereffect(){
        if(monster1.getHP()<=0 || monster2.getHP()<=0){
            Battle.switchmonster();
        }
    }
}
