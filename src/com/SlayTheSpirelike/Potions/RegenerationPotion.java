package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class RegenerationPotion extends Potion {
    public RegenerationPotion() {
        super("Regeneration Potion", "Self","Rare","resources/RegenPotion.png","Every turn, \n" +
                "heal 2 health");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setHealth(kapal.getHealth()+2);
            if (kapal.getHealth()>kapal.getMaxhealth()){
                kapal.setHealth(kapal.getMaxhealth());
            }
        }

    }

    @Override
    public Potion copy() {
        return new RegenerationPotion();
    }
}
