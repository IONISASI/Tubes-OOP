import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private int playerId;
    private String playerName;
    private List<Monster> monsterList = new ArrayList<Monster>();
    protected Monster myMonster;
    protected List<Monster> NPMonsters = new ArrayList<Monster>();

    public Player(int playerId, String playerName){
        this.playerId = playerId;
        this.playerName = playerName;
        this.myMonster = monsterList.get(0);
        this.NPMonsters.addAll(monsterList);
    }

    public Player(int playerId, String playerName, List<Monster> monsterList){
        this.playerId = playerId;
        this.playerName = playerName;
        this.monsterList = monsterList;
    }

    public int getPlayerId(){
        return this.playerId;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public void addMonster(Monster monster) {
        monsterList.add(monster);
    }

    public List<Monster> getMonsterList() {
        return this.monsterList;
    }

    public void randomMonster(){
        Collections.shuffle(monsterList);
    }
    public void showNPMonster() {
        System.out.println("---------NON PLAYABLE MONSTER---------");
        if (NPMonsters.size() > 0) {
            for (int i = 0; i < NPMonsters.size(); i++) {
                System.out.printf("[%d] %s\n", i+1, NPMonsters.get(i).getNama());
            }   
        } else {
            System.out.println("Monster sudah habis!");
        }
    }
    public void showMonster() {
        System.out.println("---------PLAYABLE MONSTER---------");
        if (myMonster != null) {
            System.out.println(myMonster.getNama());
        } else {
            System.out.println("Belum ada monster yang dipilih");
        }
    }
    public void switchMonster() {
        showNPMonster();
        if (NPMonsters.size() > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Select monster : ");
            int input = sc.nextInt();
            Monster monster = myMonster;
            myMonster = NPMonsters.get(input-1);
            NPMonsters.remove(input-1);
            NPMonsters.add(monster);
            sc.close();
        }
    }
    public void selectMonster() {  
        showNPMonster();
        Scanner sc = new Scanner(System.in);
        System.out.printf("Select monster : ");
        int input = sc.nextInt();
        myMonster = NPMonsters.get(input-1);
        NPMonsters.remove(input-1);
        sc.close();
    }
    public void monsterDie() {
        System.out.println("%s's monster telah mati %s "+ getPlayerName() + myMonster.getNama());
        for (Monster monster : monsterList) {
            if (monster.getNama().equals(myMonster.getNama())) {
                monsterList.remove(monster);
            }
        }
        System.out.println("Select another active monster");
        selectMonster();
    }
}