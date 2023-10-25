package kg.geeks.game.players;

import java.util.Random;

public class Magic extends Hero{

    private int boostDamage = 20;
    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero: heroes){
            hero.setDamage(hero.getDamage() + this.boostDamage);
            System.out.println("Magic" + " boosted " + hero.getName() + " boosted " + boostDamage);
        }
    }
}
