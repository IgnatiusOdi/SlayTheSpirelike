package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class EmergencyFoodRelic extends Relic {
    public EmergencyFoodRelic() {
        super("Emergency Food Relic", "Common", "Damaged", "resources/emergency food.png","When health is at \n" +
                "or below 50%, heal 5 hp \n" +
                "(1 time used per battle)");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&kapal.getHealth()<=kapal.getMaxhealth()/2&&active){
            kapal.setHealth(kapal.getHealth()+5);
            active=false;
        }
    }

    @Override
    public Relic copy() {
        return new EmergencyFoodRelic();
    }
}
