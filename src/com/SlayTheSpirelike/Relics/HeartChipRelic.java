package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class HeartChipRelic extends Relic {
    public HeartChipRelic() {
        super("HeartChip", "Passive","Passive","resources/tankerrelic.png","Raise your \n" +
                "max health \n" +
                "by 8 (Passive)");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            kapal.setMaxhealth(kapal.getMaxhealth()+8);
            kapal.setHealth(kapal.getHealth()+8);
            active=false;
        }

    }

    @Override
    public void deactivate(Kapal kapal) {

    }
}
