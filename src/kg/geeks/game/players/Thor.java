package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

import java.util.Random;

public class Thor  extends Hero{



    public Thor(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.STUN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random thor = new Random();
        boolean stun = thor.nextBoolean();
        if(stun){
            {
                boss.setStunned(true);
                System.out.println("Thor stunned BOSS");
            }
        }

    }
}

