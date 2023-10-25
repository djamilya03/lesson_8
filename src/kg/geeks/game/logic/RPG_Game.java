package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;
    public  static void startGame(){
        Boss boss = new Boss(1000, 50, "Anny");
        Warrior warrior1 = new Warrior(270,10,"Halk");
        Warrior warrior2 = new Warrior(290,15,"Piter");
        Medic doc = new Medic(250,5,"Maks", 15);
        Medic assistant = new Medic(300,5, "Erik" , 5);
        Magic magic = new Magic(280, 20,"Bin");
        Berserk berserk = new Berserk(260,15,"Fredrik");
        Witcher witcher = new Witcher(250, 0, "Lord" );
        Thor thor = new Thor(270, 20, "Fenix");

        Hero[] heroes = {warrior1, warrior2 , doc, assistant, magic, berserk,witcher,thor};

        showStatistics(boss, heroes);

        while (!isGameOver(boss,heroes)){
            playRound(boss,heroes);
        }

    }
    private static  void  showStatistics(Boss boss , Hero[] heroes){
        System.out.println(" ROUND: " + roundNumber + "---------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length ; i++) {
            System.out.println(heroes[i]);

        }
    }
    private static boolean isGameOver(Boss boss, Hero[] heroes){
        if(boss.getHealth() <= 0){
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead){
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
    private static void playRound(Boss boss, Hero[] heroes){
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length ; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0 && boss.getDefence() != heroes[i].getAbility()  )
            heroes[i].attack(boss);
            heroes[i].applySuperPower(boss,heroes);
        }
        showStatistics(boss, heroes);
    }
}
