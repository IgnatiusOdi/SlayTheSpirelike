package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Relic;

public class WhiteBeastStatueRelic extends Relic {
    public WhiteBeastStatueRelic() {
        super("White Beast Statue Relic", "Uncommon", "End Battle","resources/WhiteBeastStatue.png","Potions always \n" +
                "drop after battle");
    }

    @Override
    public void activate(Battle battle) {
        if (active){
            battle.setPotionchance(40);
            active=false;
        }
    }

    @Override
    public Relic copy() {
        return new WhiteBeastStatueRelic();
    }
}
