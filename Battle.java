import java.util.*; 

public class Battle extends Player implements Statcon{
    private static Player player1;
    private static Player player2;
    private static int turn;
    private static int nextturn;
    List<Player> somePlayerNameList;
    public Battle(int playerId, String playerName, List<Monster> monsterList){
        super(playerId, playerName, monsterList);
    }
    public void burn(Monster m){
        double HP = m.getMaxHP()*1/8;
        double att = m.getAtt()*1/2;
        m.setHP(HP);
        m.setAtt(att);
        System.out.println("| " + m.getNama() + " terkena burn!!! |");
    }
    public void poison(Monster m){
        double HP = 1/16*m.getMaxHP();
        m.setHP(HP);
        System.out.println("| " + m.getNama() + " terkena poison!!! |");
    }
    public void sleep(Monster m, List<Player> somePlayerNameList){
        int x = (int) (Math.random() * 7) + 1;
        for(int i=0; i<=x; i++){
            Main.skipturn(true, somePlayerNameList);
        }
        System.out.println("| " + m.getNama() + " terkena sleep selama " + x + "putaran !!! |");
    }
    public void paralyze(Monster m, List<Player> somePlayerNameList){
        double speed = m.getspeed()*1/2;
        m.setSpeed(speed);
        int y = new Random().nextInt(4);
        if(y==2){
            Main.skipturn(true, somePlayerNameList);
            System.out.println("| " + m.getNama() + " terkena skip sebanyak 1 putaran !!! |");
        }
        System.out.println("| " + m.getNama() + " terkena paralyze !!! |");
    }
    public static void turn(){
        turn = new Random().nextInt(2);
        if(turn==0){
            System.out.println("Giliran "+ player1.getPlayerName());
            turnprint();
        }
        else{
            System.out.println("Giliran "+ player2.getPlayerName());
            turnprint();
        }
    }
    
    public static void nextturn(){
        if(turn==0){
            nextturn = turn+1;
        }
        else{
            nextturn = turn-1;
        }
    }
    
    public static int getturn(){
        return turn;
    }
    
    public static int getnextturn(){
        return nextturn;
    } 
    
    public static void skipturn(int a){
        for(int i=0;i<a;i++){
            if(nextturn==0){
                turn = 1;
            }
            else{
                turn = 0;
            }
        }
    }
    
    public static void turnprint(){
        System.out.println("-------- TURN --------");
        System.out.println("Petunjuk: mohon tulis angkanya saja");
        System.out.println("(1) Move");
        System.out.println("(2) Switch");
    }
}