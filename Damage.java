import java.util.*;

public class Damage {
    static Monster monster1;
    static Monster monster2;
    
    public static void burns() {
      if (monster2.getStatuscon().equals("BURN")) {
        double d = monster2.getHP()*0.125;
        System.out.println();
        System.out.println("| " + monster2.getStatuscon() + " | " + monster2.getNama() + " terkena damage sejumlah " + String.valueOf(d));
        monster2.setHP(monster2.getHP()-d);
        // double burnedAtt = monster2.getAtt()*0.5;
        // monster2.setAtt(burnedAtt);
      }
    }
  
    
    public static void poisons () {
      if (monster2.getStatuscon().equals("POISON")) {
        double d = monster2.getHP()*0.0625;
        System.out.println();
        System.out.println("| " + monster2.getStatuscon() + " | " + monster2.getNama() + " terkena damage sejumlah " + String.valueOf(d));
        monster2.setHP(monster2.getHP()-d);
      }
    }
  
    
    public static void sleeps (Monster m, List<Player> somePlayerNameList){
        if (monster2.getStatuscon().equals("SLEEP")){
        int x = (int) (Math.random() * 7) + 1;
        System.out.println();
        System.out.println("| " + m.getNama() + " terkena sleep selama " + x + " putaran !!! |");
        while(monster2.getStatuscon().equals("SLEEP")){
            Main.skipturn(true, somePlayerNameList);
        }
    }
    }
  

    public static void paralyzes (Monster m, List<Player> somePlayerNameList){
        if (monster2.getStatuscon().equals("PARALYZE")){
        double speed = m.getspeed()*1/2;
        m.setSpeed(speed);
        int y = new Random().nextInt(4);
        if(y==2){
            System.out.println();
            System.out.println("| " + m.getNama() + " terkena skip sebanyak 1 putaran !!! |");
            Main.skipturn(true, somePlayerNameList);
        }
        System.out.println();
        System.out.println("| " + m.getNama() + " terkena paralyze !!! |");
    }
    }

    public static void calculateDamage (Move move, List<Player> somePlayerNameList){

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
        if (monster1.getStatuscon().equals("BURN")){
            b = 0.5;
        }
        if (move.getMoveType().equals("NORMAL")){
            NormalMove m = Config.getNormalMove(move.getId());
            d = Math.floor((m.getBasePower()*(monster1.getAtt()/monster2.getDef())+2) * a * eff * b);
        } else if(move.getMoveType().equals("SPECIAL")){
            SpecialMove m = Config.getSpecialMove(move.getId());
            d = Math.floor((m.getBasePower()*(monster1.getspatt()/monster2.getspdef())+2) * a * eff * b);
        } else if(move.getMoveType().equals("STATUS")){
            StatusMove m = Config.getStatusMove(move.getId());
            if(m.getStatcon().equals("BURN")){
                monster2.setStatuscon("BURN");
                System.out.println();
                System.out.println("| " + monster2.getStatuscon() + " | " + monster2.getNama() + " terkena status " + monster2.getStatuscon());
            }else if(m.getStatcon().equals("POISON")){
                monster2.setStatuscon("POISON");
                System.out.println();
                System.out.println("| " + monster2.getStatuscon() + " | " + monster2.getNama() + " terkena status " + monster2.getStatuscon());
            }else if(m.getStatcon().equals("SLEEP")){
                monster2.setStatuscon("SLEEP");
                System.out.println();
                System.out.println("| " + monster2.getStatuscon() + " | " + monster2.getNama() + " terkena status " + monster2.getStatuscon());
                sleeps(monster2, somePlayerNameList);
            }else if(m.getStatcon().equals("PARALYZE")){
                monster2.setStatuscon("PARALYZE");
                System.out.println();
                System.out.println("| " + monster2.getStatuscon() + " | " + monster2.getNama() + " terkena status " + monster2.getStatuscon());
                paralyzes(monster2, somePlayerNameList);
            }
        } else if (move.getMoveType().equals("DEFAULT")) {//default move
            DefaultMove m = DefaultMove.getInstance();
            d = Math.floor((m.getBasePower()*(monster1.getAtt()/monster2.getDef())+2) * a * eff * b);

            double dself = Math.floor(0.25*monster1.getHP());
            monster1.setHP(monster1.getHP()-dself);
            System.out.println();
            System.out.println(monster1.getNama() + " terkena self-damage sejumlah " + String.valueOf(dself));
        }

        if  (!(d == 0)) {        
          System.out.println();
          System.out.println(monster2.getNama() + " terkena damage sejumlah " + String.valueOf(d));
          monster2.setHP(monster2.getHP()-d);
        }
    }
  
    public static void aftercalculateDamage() {
        if (monster1.getStatuscon().equals("BURN")){
            burns();
        } else if (monster1.getStatuscon().equals("POISON")){
            poisons();
        }
    }
  
    public static void afterEffect(){
      if (monster1.getHP() <= 0){
            monster1.setStatuscon("DEAD");
        }
      
        if (monster2.getHP() <= 0){
            monster2.setStatuscon("DEAD");
        }
    }
}