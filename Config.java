import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class Config{
    static List<Move> moveList = new ArrayList<Move>();
    static List<Monster> monsterList = new ArrayList<Monster>();
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

    // dalem sini harus ada config Monster, element effectivity, sama Move
    // harusnya mirip2 ky gini untuk config lainnya. yg mo nyoba bikin sabi
    public Config() throws IOException{
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
            
            Monster mon = new Monster(id, namaMon, elementTypes, hp, att, def, spatt, spdef, speed, moves);
            monsterList.add(mon);
                
        }
        scanMonster.close();

        //config effectivity
        File fileEffectivity = new File("src\\effectivity.txt");
        Scanner scanEff = new Scanner(fileEffectivity);

        while(scanEff.hasNextLine()){
            String line = scanEff.nextLine();
            String[] vals = line.split(";");
            ElementType source = ElementType.valueOf(vals[0]);
            ElementType target = ElementType.valueOf(vals[1]);
            double eff = Double.parseDouble(vals[2]);

            Effectivity effectivity = new Effectivity(source, target, eff);
            // effList.add(effectivity);
        }
        scanEff.close();

        //config moves
    }
}

