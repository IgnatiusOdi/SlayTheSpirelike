package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Relic;

public class BagOfPreparationRelic extends Relic {
    public BagOfPreparationRelic() {
        super("Bag of Preparation Relic", "Common", "Start Turn", "resources/BagofPreparation.png","At the start \n" +
                "of each turn, draw 1 \n" +
                "additional cards ");
    }

    @Override
    public void activate(Battle battle) {
        if (active){
            battle.draw(1);
        }
    }

    @Override
    public Relic copy() {
        return new BagOfPreparationRelic();
    }
}
