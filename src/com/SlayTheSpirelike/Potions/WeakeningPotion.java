package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Potion;

public class WeakeningPotion extends Potion {
    public WeakeningPotion() {
        super("Weakening Potion", "Enemy", "Common", "resources/WeakPotion.png","Decrease enemy \n" +
                "attack by 3");
    }

    @Override
    public void activate(Enemy enemy) {
        if (active){
            enemy.setWeak(enemy.getWeak()+3);
            active = false;
        }
    }

    @Override
    public Potion copy() {
        return new WeakeningPotion();
    }
}
