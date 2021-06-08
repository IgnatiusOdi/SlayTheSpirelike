package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class PearRelic extends Relic {
    public PearRelic() {
        super("Pear Relic", "Uncommon","Passive","resources/pear.png","raise max health\n" +
                "by 4 (Passive)");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            kapal.setMaxhealth(kapal.getMaxhealth()+4);
            kapal.setHealth(kapal.getHealth()+4);
            active=false;
        }

    }

    @Override
    public void deactivate(Kapal kapal) {

    }

    @Override
    public Relic copy() {
        return new PearRelic();
    }
}
