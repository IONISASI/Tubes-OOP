import java.util.*;

public class Damage implements Statcon{
    static Monster monster1;
    static Monster monster2;
    private static Player player1;
    private static Player player2;
    // public Damage(int id, String nama, List<ElementType> elementTypesList, Stats baseStats, List<Move> movesList, double HP){
    //     super(id, nama, elementTypesList, baseStats, movesList, HP);
    // }
    
    public void burn(Monster m){
        double HP = m.getHP()*1/8;
        double att = m.getAtt()*1/2;
        m.setHP(HP);
        m.setAtt(att);
    }
  
    public void poison(Monster m){
        double HP = 1/16*m.getHP();
        m.setHP(HP);
    }
  
    public void sleep(){
        int x = (int) (Math.random() * 7) + 1;
        Battle.skipturn(x);
    }
  
    public void paralyze(Monster m){
        double speed = m.getspeed()*1/2;
        m.setSpeed(speed);
        int y = new Random().nextInt(4);
        if(y==2){
            Battle.skipturn(1);
        }
    }

    /*public double getEff(Monster monster1, Monster monster2){
        
    }*/
  
    public static void calculateDamage(Move move, List<Player> player1){

        double min = 0.85;  
        double max = 1;  
        double a = Math.random()*(max-min+1)+min; 
        double d = 0;
        double eff = 0;
        for(Effectivity effect : Config.effList){
            for(ElementType et : monster2.getElementTypesList()){
                if(move.getElementType().equals(effect.getSource()) && et.equals(effect.getTarget())){
                    eff = effect.getEffectivity();
                }
            }
        }
        double b = 1;
        if(monster1.getStatuscon().equals("BURN")){
            b = 0.5;
        }
        if(move.getMoveType().equals("NORMAL")){
            NormalMove m = Config.getNormalMove(move.getId());
            d = Math.floor((m.getBasePower()*(monster1.getAtt()/monster2.getDef())+2) * a * eff * b);
        }else if(move.getMoveType().equals("SPECIAL")){
            SpecialMove m = Config.getSpecialMove(move.getId());
            d = Math.floor((m.getBasePower()*(monster1.getspatt()/monster2.getspdef())+2) * a * eff * b);
        }else if(move.getMoveType().equals("STATUS")){
            StatusMove m = Config.getStatusMove(move.getId());
            if(m.getStatcon().equals("BURN")){
                monster2.setStatuscon("BURN");
            }else if(m.getStatcon().equals("POISON")){
                monster2.setStatuscon("POISON");
            }else if(m.getStatcon().equals("SLEEP")){
                monster2.setStatuscon("SLEEP");
                //sleep(); gatau gmn ini
            }else if(m.getStatcon().equals("PARALYZE")){
                monster2.setStatuscon("PARALYZE");
                //paralyze(monster2); gatau gmn
            }
        }else{//default move
            DefaultMove m = new DefaultMove();
            d = Math.floor((m.getBasePower()*(monster1.getAtt()/monster2.getDef())+2) * a * eff * b);
            monster1.setHP(Math.floor(1/4*monster1.getHP()));
        }
        monster2.setHP(monster2.getHP()-d);
        
        
        
        /*if(Move.effect().contains("BURN") && Move.moveType().contains("NORMAL") && Move.target().contains("ENEMY")){
            d = (java.lang.Math.floor((Move.getBasePower()*(monster1.getAtt()/monster2.getDef())+2)* a * Effectivity.getEffectivity() * 0.5));
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
        }*/
        
    }
    public static void aftercalculateDamage(Move move, List<Player> somePlayerNameList){
        double d = 0;
        double burn = 1/8;
        double poison = 1/16;
        if(monster2.getStatuscon().equals("BURN")){
            //burn(monster2); ini kena burn hrs nya tiap dia dapet giliran main kan?
            double maxhp = monster2.getMaxHP();
            d = Math.floor(maxhp*burn);
        }else if(monster2.getStatuscon().equals("POISON")){
            double maxhp = monster2.getMaxHP();
            d = Math.floor(maxhp*poison);
        }
        monster2.setHP(monster2.getHP()-d);
        /*if(Move.effect().contains("BURN") && Move.target().contains("OWN")){
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
        }*/
        
    }
  
    public static void afterEffect(){
        System.out.println("");
        System.out.println("| " + monster2.getNama() + " terkena damage!!! |");
        System.out.println("");
        if(monster2.getHP() < 0){
            System.out.println("HP " + monster2.getNama() + " : " + "0/" + monster2.getMaxHP());
            System.out.println(monster2.getNama() + " telah dikalahkan..");
            monster2.setStatuscon("DEAD");
        }else{
            System.out.println(" HP " + monster2.getNama() + " : " + monster2.getHP() + "/" + monster2.getMaxHP());
        }
    }
}