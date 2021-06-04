package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Potion;

public class WeakeningPotion extends Potion {
    private boolean used;
    public WeakeningPotion() {
        super("Weakening Potion", "Enemy", "Common", "resources/WeakPotion.png","Decrease enemy \n" +
                "attack by 5");
        used = true;
    }

    @Override
    public void activate(Enemy enemy) {
        if (active&&used){
            enemy.setAtkhigh(enemy.getAtkhigh()-5);
            enemy.setAtklow(enemy.getAtklow()-5);
            if (enemy.getAtkhigh()<0){
                enemy.setAtkhigh(0);
            }
            if (enemy.getAtklow()<0){
                enemy.setAtklow(0);
            }
            used = false;
        }
    }

    @Override
    public void deactivate(Enemy enemy) {

    }

    @Override
    protected Potion copy() {
        return new WeakeningPotion();
    }
}
