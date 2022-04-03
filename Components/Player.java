import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private int playerId;
    private String playerName;
    private List<Monster> monsterList = new ArrayList<Monster>();

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
}