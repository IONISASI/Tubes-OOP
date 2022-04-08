import java.util.*; 

public class Battle extends Player{
    private static Player player1;
    private static Player player2;
    private static int turn;
    private static int nextturn;
    public Battle(int playerId, String playerName, List<Monster> monsterList){
        super(playerId, playerName, monsterList);
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
    
    public static void action() {
        System.out.printf("Pilihan : ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 1) {
            moveMonster();
        } else if (input == 2) {
            switchMonster();
        }
        sc.close();
    }
    
    public static void moveMonster(){

    }
    
    public static void switchMonster(){

    }
    
    public static void gameover(){
        if(player1.getMonsterList().isEmpty()){
            System.out.println("Game telah berakhir, pemenangnya adalah "+ player1.getPlayerName());
            //exitgame();
        }
        else{
            System.out.println("Game telah berakhir, pemenangnya adalah "+ player2.getPlayerName());
            //exitgame();
        }
    }
}
