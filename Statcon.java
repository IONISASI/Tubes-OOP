import java.util.List;
public interface Statcon {
    void burn(Monster m);
    void poison(Monster m);
    void sleep(Monster m, List<Player> somePlayerNameList);
    void paralyze(Monster m, List<Player> somePlayerNameList);
}