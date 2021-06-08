package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class StrawberryRelic extends Relic {
    public StrawberryRelic() {
        super("Strawberry Relic", "Common","Passive","resources/strawbewwy.png","Raise max health \n" +
                "by 2 (Passive)");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            kapal.setMaxhealth(kapal.getMaxhealth()+2);
            kapal.setHealth(kapal.getHealth()+2);
            active=false;
        }

    }

    @Override
    public void deactivate(Kapal kapal) {

    }

    @Override
    public Relic copy() {
        return new StrawberryRelic();
    }
}
