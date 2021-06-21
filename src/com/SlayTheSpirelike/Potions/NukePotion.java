package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Potion;

public class NukePotion extends Potion {
    public NukePotion() {
        super("Nuke Potion", "Enemy", "Common", "resources/NukePotion.png","Deal 5 damage \n" +
                "to enemy");
    }
    @Override
    public void activate(Enemy enemy) {
        if (active){
            enemy.setHealth(enemy.getHealth()-5);
            active=false;
        }
    }

    @Override
    public Potion copy() {
        return new NukePotion();
    }
}
