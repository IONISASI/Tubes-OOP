import java.util.*;

public class Damage implements Statcon{
    private static Monster monster1;
    private static Monster monster2;
    private static Player player1;
    private static Player player2;
    // public Damage(int id, String nama, List<ElementType> elementTypesList, Stats baseStats, List<Move> movesList, double HP){
    //     super(id, nama, elementTypesList, baseStats, movesList, HP);
    // }
    
    public void burn(double HP, double att){
        HP = HP*1/8; att = att*1/2;
    }
    public static void burning(double HP, double att){
        HP = HP*1/8; att = att*1/2;
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
        double min = 0.85;  
        double max = 1;  
        double a = Math.random()*(max-min+1)+min; 
        double d = 0;
        if(Move.effect().contains("BURN") && Move.moveType().contains("NORMAL") && Move.target().contains("ENEMY")){
            d = (java.lang.Math.floor((NormalMove.getBasePower()*(monster1.getAtt()/monster2.getDef())+2)* a * Effectivity.getEffectivity() * 0.5));
        }
        else if(Move.effect().contains("BURN") && Move.moveType().contains("SPECIAL") && Move.target().contains("ENEMY")){
            d = (java.lang.Math.floor((SpecialMove.getBasePower()*(monster1.getspatt()/monster2.getspdef())+2)* a * Effectivity.getEffectivity() * 0.5));
        }
        else if(Move.moveType().contains("SPECIAL") && Move.target().contains("ENEMY")){
            d = (java.lang.Math.floor((SpecialMove.getBasePower()*(monster1.getspatt()/monster2.getspdef())+2)* a * Effectivity.getEffectivity() * 1));
        }
        else if(Move.moveType().contains("NORMAL") && Move.target().contains("ENEMY")){
            d = (java.lang.Math.floor((NormalMove.getBasePower()*(monster1.getAtt()/monster2.getDef())+2)* a * Effectivity.getEffectivity() * 1));
        }
        else if(Move.effect().contains("BURN") && Move.moveType().contains("NORMAL") && Move.target().contains("OWN")){
            d = (java.lang.Math.floor((NormalMove.getBasePower()*(monster2.getAtt()/monster1.getDef())+2)* a * Effectivity.getEffectivity() * 0.5));
        }
        else if(Move.effect().contains("BURN") && Move.moveType().contains("SPECIAL") && Move.target().contains("OWN")){
            d = (java.lang.Math.floor((SpecialMove.getBasePower()*(monster2.getspatt()/monster1.getspdef())+2)* a * Effectivity.getEffectivity() * 0.5));
        }
        else if(Move.moveType().contains("SPECIAL") && Move.target().contains("OWN")){
            d = (java.lang.Math.floor((SpecialMove.getBasePower()*(monster2.getspatt()/monster1.getspdef())+2)* a * Effectivity.getEffectivity() * 1));
        }
        else if(Move.moveType().contains("NORMAL") && Move.target().contains("OWN")){
            d = (java.lang.Math.floor((NormalMove.getBasePower()*(monster2.getAtt()/monster1.getDef())+2)* a * Effectivity.getEffectivity() * 1));
        }
        return d;
    }
    public static double aftercalculateDamage(){
        double d = 0;
        if(Move.effect().contains("BURN") && Move.target().contains("OWN")){
            d = (java.lang.Math.floor(monster1.getHP()/8));
        }
        else if(Move.effect().contains("POISON")&& Move.target().contains("OWN")){
            d = (java.lang.Math.floor(monster1.getHP()/16));
        }
        else if(Move.effect().contains("BURN") && Move.target().contains("ENEMY")){
            d = (java.lang.Math.floor(monster2.getHP()/8));
        }
        else if(Move.effect().contains("POISON") && Move.target().contains("ENEMY")){
            d = (java.lang.Math.floor(monster2.getHP()/16));
        }
        return d;
    }
    public static void aftereffect(){
        if(monster1.getHP()<=0){
            player1.switchMonster();
        }
        else if(monster2.getHP()<=0){
            player2.switchMonster();
        }
    }
    public static void normalattack(Monster monster1, Monster monster2) {
        System.out.println("Normal move");
        System.out.println("Calculating....");
        double d = calculateDamage();
        System.out.println(monster2.getHP() - d);
    }
    public static void spattack(Monster monster1, Monster monster2) {
        System.out.println("Special move");
        System.out.println("Calculating....");
        double d = calculateDamage();
        System.out.println(monster2.getHP() - d);
    }
    public static void burn(Monster monster1, Monster monster2) {
        System.out.println("Burn");
        System.out.println("Calculating....");
        double d = calculateDamage();
        System.out.println(monster2.getHP() - d);
        burning(monster2.getHP(), monster2.getAtt());
    }
}
