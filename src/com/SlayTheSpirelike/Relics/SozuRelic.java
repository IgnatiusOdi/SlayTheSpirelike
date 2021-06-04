package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class SozuRelic extends Relic {
    public SozuRelic() {
        super("Sozu Relic", "Boss Drop", "Start Turn", "resources/Sozu.png","Gain 1 energy at the \n" +
                "start of each turn. \n" +
                "You can no longer \n" +
                "obtain potions");
    }
    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setEnergy(kapal.getEnergy()+1);
        }
    }

    @Override
    public void activate(Battle battle) {
        if (active){
            battle.setNopotion(true);
        }
    }

    @Override
    protected Relic copy() {
        return new SozuRelic();
    }
}
