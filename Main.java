import java.lang.System;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void Menu(){
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
    }
    public static void AppMenu(){
        // Start game
        System.out.println("--------------------");
        System.out.println("1. Help");
        System.out.println("2. View Monster Info");
        System.out.println("3. View Game Info");
        System.out.println("4. Exit");
        System.out.println("--------------------");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Menu();
        System.out.println("Masukkan menu: ");
        int menu = input.nextInt();
        if(menu == 1){
            System.out.println("Masukkan jumlah pemain: ");
            int jumlahPemain = input.nextInt();

            // jumlah pemain tidak lebih dan kurang dari 2
            while (jumlahPemain != 2){
                System.out.println("Jumlah pemain tidak boleh lebih dan kurang dari 2");
                jumlahPemain = input.nextInt();
            }

            List<Player> playerNameList = new ArrayList<Player>(jumlahPemain);
            for (int i=0; i<jumlahPemain;i++){
                System.out.println("Nama pemain ke " + i + ": ");
                String namaPemain = input.next();
                playerNameList.add(new Player(i, namaPemain));
            }
            System.out.println();

            // mulai game
            AppMenu();
            System.out.println("Masukkan menu: ");
            int noMenu = input.nextInt();

            if(noMenu == 1){
                System.out.println("--------HELP--------");
            }else if(noMenu == 2){
                System.out.println("--------MONSTER INFO--------");
            }else if(noMenu == 3){
                System.out.println("--------GAME INFO--------");
            }
        }
    }
}
