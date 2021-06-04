package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Potion;

public class SmokePotion extends Potion {
    public SmokePotion() {
        super("Smoke Potion", "Battle", "Uncommon", "resources/SmokeBomb.png","Escape from a non-boss battle. \n" +
                "Receive no reward");
    }

    @Override
    public void activate(Battle battle) {
        if (active){
            battle.escape();
            active=false;
        }
    }

    @Override
    public Potion copy() {
        return new SmokePotion();
    }
}
