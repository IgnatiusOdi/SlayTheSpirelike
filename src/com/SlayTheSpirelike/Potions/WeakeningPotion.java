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
            enemy.setWeak(enemy.getWeak()+5);
            used = false;
        }
    }

    @Override
    public void deactivate(Enemy enemy) {

    }

    @Override
    public Potion copy() {
        return new WeakeningPotion();
    }
}
