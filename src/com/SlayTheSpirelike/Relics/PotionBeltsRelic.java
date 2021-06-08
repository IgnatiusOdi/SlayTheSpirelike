package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class PotionBeltsRelic extends Relic {
    public PotionBeltsRelic() {
        super("Potion Belts Relic", "Uncommon", "Pick Up", "resources/PotionBelt.png","Upon pick up, \n" +
                "gain 2 potion slots");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active) {
            kapal.setPotionLimit(kapal.getPotionLimit() + 2);
        }
    }

    @Override
    public Relic copy() {
        return new PotionBeltsRelic();
    }
}
