package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class CannontizerRelic extends Relic {
    public CannontizerRelic() {
        super("Cannontizer Relic", "Common", "Damage", "resources/cannon.png","Increase your attack \n" +
                "by 1 (Passive");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            kapal.setAttack(kapal.getAttack()+1);
            active=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {

    }

    @Override
    public Relic copy() {
        return new CannontizerRelic();
    }
}
