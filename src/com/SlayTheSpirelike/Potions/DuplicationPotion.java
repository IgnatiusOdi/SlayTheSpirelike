package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class DuplicationPotion extends Potion {
    public DuplicationPotion() {
        super("Duplication Potion", "Battle", "Common", "resources/DuplicationPotion.png","Your next card \n" +
                "is played twice");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            kapal.setTwice(2);
            active=false;
        }
    }

    @Override
    protected Potion copy() {
        return new DuplicationPotion();
    }
}
