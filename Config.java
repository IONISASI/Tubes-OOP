import java.util.*;
import java.io.*;


public class Config{
    static List<Monster> monsterList = new ArrayList<Monster>();
    static List<Effectivity> effList = new ArrayList<Effectivity>();
    static List<Move> moveList = new ArrayList<Move>();
    static List<NormalMove> normalMoveList = new ArrayList<NormalMove>();
    static List<SpecialMove> specialMoveList = new ArrayList<SpecialMove>();
    static List<StatusMove> statusMoveList = new ArrayList<StatusMove>();
    //ntar tambah list yg perlu di cofig
    
    //untuk ngambil Move dari id nya
    public Move getMove(int id){
        for (Move m : moveList){
            if(m.getId() == id ){
                return m;
            }
        }
        return null;
    }
    public static NormalMove getNormalMove(int id){
      for (NormalMove m : normalMoveList){
          if(m.getId() == id ){
              return m;
          }
      }
      return null;
    }
    public static SpecialMove getSpecialMove(int id){
      for (SpecialMove m : specialMoveList){
          if(m.getId() == id ){
              return m;
          }
      }
      return null;
    }
    public static StatusMove getStatusMove(int id){
      for (StatusMove m : statusMoveList){
          if(m.getId() == id ){
              return m;
          }
      }
      return null;
    }

    public static void testMonster() {
        for (Monster mon : monsterList) {
          System.out.println();
          System.out.println("Pokemon Name: " + mon.getNama());
          System.out.println("Pokemon Element Type: " + mon.getElementTypesList());
          System.out.println("Pokemon Move List:");
          for (Move m : mon.getMovesList()) {
            System.out.println("- " + m.getName() + ", " + m.getElementType());
          }
        }
        // for (Effectivity eff : effList){
        // System.out.println(eff.getTarget());
        // }
      }
    
      public static void test() {
        for (Monster mon : monsterList) {
          System.out.println("Pokemon Name: " + mon.getNama());
          System.out.println("Pokemon Element Type: " + mon.getElementTypesList());
          System.out.println("Pokemon Move List:");
          System.out.println();
          for (Move m : mon.getMovesList()) {
            System.out.println("- " + m.getName() + ", " + m.getElementType());
          }
        }
    
        for (Move mov : moveList) {
          System.out.println(mov.getName());
        }
    
        for (Effectivity eff : effList) {
          System.out.println(eff.getTarget());
        }
      }
    
      // untuk ngetes:D jgn lupa nama file nya
      public static void main(String[] args) throws IOException {
        new Config();
        test();
      }

    // dalem sini harus ada config Monster, element effectivity, sama Move
    // harusnya mirip2 ky gini untuk config lainnya. yg mo nyoba bikin sabi
    public Config() throws IOException{
        //config moves
        File fileMove = new File("move.txt");
        Scanner scanMove = new Scanner(fileMove);

        while(scanMove.hasNextLine()){
            String line = scanMove.nextLine();
            String[] vals = line.split(";");
            if(vals[1].equals("NORMAL")){
                Integer id = Integer.parseInt(vals[0]);
                String mt = vals[1];
                String name = vals[2];
                ElementType et = ElementType.valueOf(vals[3]);
                Integer acc = Integer.parseInt(vals[4]);
                Integer pri = Integer.parseInt(vals[5]);
                Integer amm = Integer.parseInt(vals[6]);
                Integer bp = Integer.parseInt(vals[8]);
                NormalMove m = new NormalMove(id, mt, name, et, acc, pri, amm, bp);
                normalMoveList.add(m);
                moveList.add(m);
            }else if(vals[1].equals("SPECIAL")){
                Integer id = Integer.parseInt(vals[0]);
                String mt = vals[1];
                String name = vals[2];
                ElementType et = ElementType.valueOf(vals[3]);
                Integer acc = Integer.parseInt(vals[4]);
                Integer pri = Integer.parseInt(vals[5]);
                Integer amm = Integer.parseInt(vals[6]);
                Integer bp = Integer.parseInt(vals[8]);
                SpecialMove m = new SpecialMove(id, mt, name, et, acc, pri, amm, bp);
                specialMoveList.add(m);
                moveList.add(m);
            }else if(vals[1].equals("STATUS")){
                Integer id = Integer.parseInt(vals[0]);
                String mt = vals[1];
                String name = vals[2];
                ElementType et = ElementType.valueOf(vals[3]);
                Integer acc = Integer.parseInt(vals[4]);
                Integer pri = Integer.parseInt(vals[5]);
                Integer amm = Integer.parseInt(vals[6]);
                String target = vals[7];
                String statcon = vals[8];
                String stat = vals[9];
                String[] valstat = stat.split(",");
                double hp = Double.parseDouble(valstat[0]);
                double att = Double.parseDouble(valstat[1]);
                double def = Double.parseDouble(valstat[2]);
                double spatt = Double.parseDouble(valstat[3]);
                double spdef = Double.parseDouble(valstat[4]);
                double speed = Double.parseDouble(valstat[5]);
                Stats stats = new Stats(hp, att, def, spatt, spdef, speed);
                StatusMove m = new StatusMove(id, mt, name, et, acc, pri, amm, target, statcon, stats);
                statusMoveList.add(m);
                moveList.add(m);
            }
        }

        scanMove.close();
        // config Monster
        File fileMonster = new File("monster.txt");
        Scanner scanMonster = new Scanner(fileMonster);

        while(scanMonster.hasNextLine()){
            String line = scanMonster.nextLine();
            String[] vals = line.split(";");
            Integer id = Integer.parseInt(vals[0]);
            String namaMon = vals[1];
            String ElTypes = vals[2];
            String[] valsElTypes = ElTypes.split(",");
            List<ElementType> elementTypes = new ArrayList<ElementType>();
            for (String elty : valsElTypes){
              ElementType et = ElementType.valueOf(elty);
              elementTypes.add(et);
            }
            String bs = vals[3];
            String[] valsbs = bs.split(",");
                double hp = Double.parseDouble(valsbs[0]);
                double att = Double.parseDouble(valsbs[1]);
                double def = Double.parseDouble(valsbs[2]);
                double spatt = Double.parseDouble(valsbs[3]);
                double spdef = Double.parseDouble(valsbs[4]);
                double speed = Double.parseDouble(valsbs[5]);
            Stats baseStats = new Stats(hp, att, def, spatt, spdef, speed);
            String move = vals[4];
            String[] valsmove = move.split(",");
            List<Move> moves = new ArrayList<Move>();
            for (String mov : valsmove){
                int idMove = Integer.valueOf(mov);
                for (Move m : moveList){
                    if(m.getId() == idMove ){
                            moves.add(m);
                    }
                }
            }
            
            Monster mon = new Monster(id, namaMon, elementTypes, baseStats, moves);
            monsterList.add(mon);
                
        }
        scanMonster.close();

        //config effectivity
        File fileEffectivity = new File("effectivity.txt");
        Scanner scanEff = new Scanner(fileEffectivity);

        while(scanEff.hasNextLine()){
            String line = scanEff.nextLine();
            String[] vals = line.split(";");
            ElementType source = ElementType.valueOf(vals[0]);
            ElementType target = ElementType.valueOf(vals[1]);
            double eff = Double.parseDouble(vals[2]);

            Effectivity effectivity = new Effectivity(source, target, eff);
            effList.add(effectivity);
        }
        scanEff.close();

        
    }
}

