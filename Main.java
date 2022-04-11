import java.lang.System;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main{
        public static void main(String[] args){
        Welcome<String> sObj = new Welcome<String>("***********POKEMON GAME***********");
        System.out.println(sObj.getObject());
        System.out.printf("Welcome to...\n");
        System.out.printf("                                  ,'\\\n");
        System.out.printf("      _.----.        ____        ,'  _\\   ___    ___     ____\n");
        System.out.printf("  _,-'       `.     |    |  /`.   \\,-'   |   \\  /   |   |    \\  |`.\n");
        System.out.printf("  \\     __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ | |\n");
        System.out.printf("   \\.   \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\| |\n");
        System.out.printf("    \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     | |\n");
        System.out.printf("     \\     ,-'/  /   \\    ,'  |  \\/ / ,`.|         /  / \\ |     | |\n");
        System.out.printf("      \\    \\ |   \\_/ |   `-.  \\    `'  / |  |    | |  \\_/ |  |\\   |\n");
        System.out.printf("      \\    \\ \\      /       `-.`.___,-'  |  |\\  /| \\      /  | |  |\n");
        System.out.printf("       \\    \\ `.__,'|  |`-._    `|       |__| \\/ |  `.__,'|  | |  |\n");
        System.out.printf("       \\_.-'        |__|    `-._ |               '-.|     '-.| |  |\n");
        System.out.printf("                                `'                            '-._|\n");
        Scanner input = new Scanner(System.in);
        menu();
        int menu = input.nextInt();
        if (menu == 1){
            
            List<Player> playerNameList = new ArrayList<Player>(2);
            for (int i=0; i<2;i++){
                System.out.println();
                System.out.println("Nama pemain ke-" + (i+1) + ": ");
                String namaPemain = input.next();
                playerNameList.add(new Player(i, namaPemain));
            }
            

            // mulai game
            try {
              new Config();
              
              System.out.println();
              Thread.sleep(500);  
              System.out.println("Memulai shuffle monster untuk player...");
              List<Monster> randomMonsterList = Config.monsterList;
              for (int i=0; i<6;i++){
                  playerNameList.get(0).addMonster(randomMonsterList.get(0));
                  playerNameList.get(1).addMonster(randomMonsterList.get(1));
                  Collections.shuffle(randomMonsterList);
              }

              System.out.println();
              // Thread.sleep(1000);  
              System.out.println("Shuffle monster selesai...");
              for (int j=0; j<2; j++){
                System.out.println();
                // Thread.sleep(500);  
                System.out.println("Player " + playerNameList.get(j).getPlayerName() + " mendapatkan monster: ");
                // Thread.sleep(500);  
                int iMon = 1;
                for (Monster mon : playerNameList.get(j).getMonsterList()) {
                  System.out.print("Monster " + (iMon++) + ": " + mon.getNama() + " " + mon.getElementTypesList() + " =");
                  for (Move m : mon.getMovesList()) {
                    System.out.print(" " + m.getName() + ",");
                  }
                  System.out.println();
                  // Thread.sleep(500);  
                }
              }
                
            } catch (Exception e) {
              
            } finally {
              battleMenu(playerNameList);
            }
        }
      input.close();
    }
    
  
    public static void menu(){
        System.out.println();
        System.out.println("-------- START MENU  --------");
        System.out.println("Petunjuk: mohon tulis angkanya saja");
        System.out.println("(1) Start Game");
        System.out.println("(2) Exit");
        System.out.println("Pilihan: ");
    }
    
    public static void viewGameInfo(List<Player> somePlayerNameList){
        System.out.println("Game ini adalah game Pokemon sederhana yang dibuat pada tahun 2022.");
        appMenu(somePlayerNameList);
    }
    public static void help(List<Player> somePlayerNameList){
      try{
        System.out.println("Aturan bermain: ");
        Thread.sleep(500);
        System.out.println("1. Setiap pemain akan mendapatkan beberapa Pokemon untuk bertarung, kemudian dapat 1 monster. ");
        Thread.sleep(500);
        System.out.println("2. Pemain dapat memilih move untuk bergerak atau switch untuk menukar pada monster yang dimiliki. ");
        Thread.sleep(500);
        System.out.println("3. Monster akan bertarung satu sama lain dan ingat ada status kondisi tertentu yang dapat merugikan monstermu. ");
        Thread.sleep(500);
        System.out.println("4. Jika nyawa monster habis, pemain harus menukar monster yang baru.  ");
        Thread.sleep(500);
        System.out.println("5. Apabila jumlah monster sudah habis, maka pemain itu yang kalah.  ");
      }
      catch (Exception e) {
              
      }
      finally{
        appMenu(somePlayerNameList);
      }
    }
  
    public static void appMenu(List<Player> somePlayerNameList){
        System.out.println();
        System.out.println("-------- MAIN MENU  --------");
        System.out.println("Petunjuk: mohon tulis angkanya saja");
        System.out.println("(1) Return to Battle");
        System.out.println("(2) Help");
        System.out.println("(3) View Monster Info");
        System.out.println("(4) View Game Info");
        System.out.println("(5) Exit");
        System.out.println("Pilihan: ");
        boolean end = false;
        Scanner sc = new Scanner(System.in);
        while (end == false) {        
          int input = sc.nextInt();
          switch(input) {
            case 1:
              end = true;
              battleMenu(somePlayerNameList);
            case 2:
              end = true;
              help(somePlayerNameList);
            case 3:
              end = true;
              viewMonsterInfo(somePlayerNameList);
            case 4:
              end = true;
              viewGameInfo(somePlayerNameList);
            case 5:
              end = true;
              System.exit(1);
          }
        }
        sc.close();
    }
    public static void turn(boolean switchTurn, List<Player> somePlayerNameList) {
      if (switchTurn) {
        Collections.reverse(somePlayerNameList);
      }
    }
    
    public static void battleMenu(List<Player> somePlayerNameList) {
      Player somePlayer = somePlayerNameList.get(0);

      monsterBattle(somePlayerNameList);
      
      boolean endMenu = false;
      while (endMenu == false) {
        System.out.println();
        System.out.println("--------  BATTLE MENU: "+ somePlayer.getPlayerName() +"  --------");
        System.out.println("Petunjuk: mohon tulis angkanya saja");
        System.out.println("(1) Move");
        System.out.println("(2) Switch");
        System.out.println("(3) Back to Menu");
        System.out.printf("Pilihan: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch(input) {
          case 1:
            endMenu = true;
            moveMenu(somePlayerNameList);
            // changeTurn(somePlayerNameList);
            break;
          case 2:
            endMenu = true;
            switchMenu(somePlayerNameList);
            // changeTurn(somePlayerNameList);
            break;
          case 3:
            endMenu = true;
            appMenu(somePlayerNameList);
            break;
        }
        sc.close();
      }
    }

    public static void moveMenu(List<Player> somePlayerNameList) {
      Player currentPlayer = somePlayerNameList.get(0);
      List<Monster> monsterList = currentPlayer.getMonsterList();
      Monster currentMonster = monsterList.get(0);
      List<Move> movesList = currentMonster.getMovesList();
      Monster enemyMonster = monsterList.get(1);

      monsterBattle(somePlayerNameList);
      
      boolean endMenu = false;
      while (endMenu == false) {
        System.out.println();
        System.out.println("--------  MOVE MENU: "+ currentPlayer.getPlayerName() +"  --------");
        System.out.println("Petunjuk: mohon tulis angkanya saja");
        int iMov = 1;
        for (Move mov : (movesList)) {
          System.out.println("(" + (iMov++) + ") " + mov.getName());
        }
        System.out.printf("Pilihan: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch(input) {
          case 1:
          endMenu = true;
          Damage.normalattack(currentMonster, enemyMonster);
          changeTurn(somePlayerNameList);
          break;
          case 2:
          endMenu = true;
          Damage.spattack(currentMonster, enemyMonster);
          changeTurn(somePlayerNameList);
          break;
          case 3:
          endMenu = true;
          Damage.burn(currentMonster, enemyMonster);
          changeTurn(somePlayerNameList);
          break;
        }
        sc.close();
      }
    }    

    public static void switchMenu(List<Player> somePlayerNameList) {
      Player currentPlayer = somePlayerNameList.get(0);
      List<Monster> monsterList = currentPlayer.getMonsterList();

      monsterBattle(somePlayerNameList);
      
      boolean endMenu = false;
      while (endMenu == false) {
        System.out.println();
        System.out.println("--------  SWITCH MENU: "+ currentPlayer.getPlayerName() +"  --------");
        System.out.println("Petunjuk: mohon tulis angkanya saja");
        int iMon = 1;
        int sizeMon = monsterList.size();
        for (int m = 0; m < sizeMon-1; m++) {
          System.out.println("(" + (iMon++) + ") " + monsterList.get((m+1)).getNama() + " (HP: " + monsterList.get((m+1)).getHP() + ")");
        }
        System.out.printf("Pilihan: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println("Swap: " + monsterList.get(input));
        try {
          Collections.swap(monsterList, 0, input);
        } catch (Exception e) {
          System.out.println("Exception thrown: " + e);
        } finally {
          endMenu = true;
          changeTurn(somePlayerNameList);
        }
        sc.close();
      }
    }

    public static void changeTurn (List<Player> somePlayerNameList) {
      Collections.reverse(somePlayerNameList);
      battleMenu(somePlayerNameList);
    }

    public static void monsterBattle(List<Player> somePlayerNameList) {
      Player currentPlayer = somePlayerNameList.get(0);
      Monster currentMonster = currentPlayer.getMonsterList().get(0);
      Player enemyPlayer = somePlayerNameList.get(1);
      Monster enemyMonster = enemyPlayer.getMonsterList().get(0);
      
      System.out.println();
      System.out.println("--------------------------------");
      System.out.println(currentPlayer.getPlayerName() + ": " + currentMonster.getNama());
      System.out.println("HP: " + currentMonster.getHP());
      System.out.println("--------------------------------");
      System.out.println(enemyPlayer.getPlayerName() + ": " + enemyMonster.getNama());
      System.out.println("HP: " + enemyMonster.getHP());
      System.out.println("--------------------------------");
    }    
  
    public static void viewMonsterInfo(List<Player> somePlayerNameList){
      Player currentPlayer = somePlayerNameList.get(0);
      Monster currentMonster = currentPlayer.getMonsterList().get(0);
      Player enemyPlayer = somePlayerNameList.get(1);
      Monster enemyMonster = currentPlayer.getMonsterList().get(1); 
        if(currentPlayer == somePlayerNameList.get(0)){
          System.out.println(currentMonster.getNama());
          currentMonster.cetak();
          appMenu(somePlayerNameList);
        }
        else if(enemyPlayer == somePlayerNameList.get(1)){
          System.out.println(enemyMonster.getNama());
          enemyMonster.cetak();
          appMenu(somePlayerNameList);
        }
    }
}