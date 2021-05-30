package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class BurningBloodRelic extends Relic {
    public BurningBloodRelic() {
        super("Burning Blood Relic", "Uncommon", "End Battle", "resources/BurningBlood.png","At the end of battle, \n" +
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
}
