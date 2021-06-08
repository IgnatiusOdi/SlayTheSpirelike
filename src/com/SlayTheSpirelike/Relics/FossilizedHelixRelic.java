package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Relic;

public class FossilizedHelixRelic extends Relic {
    public FossilizedHelixRelic() {
        super("Fossilized Helix Relic", "Rare", "Start Battle", "resources/FossilizedHelix.png","Prevent the first \n" +
                "time you would lose \n" +
                "health in battle");
    }

    @Override
    public void activate(Battle battle) {
        if (active){
            battle.setInvincible(true);
            active=false;
        }
    }

    @Override
    public Relic copy() {
        return new FossilizedHelixRelic();
    }
}
