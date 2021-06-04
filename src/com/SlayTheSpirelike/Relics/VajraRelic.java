package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class VajraRelic extends Relic {
    boolean on;
    public VajraRelic() {
        super("Vajra Relic", "Special", "Start Turn", "resources/warshiprelic.png","At start turn \n" +
                "when health under 50%, \n" +
                "increase attack by 2");
        on = true;
    }

    @Override
    public void activate(Kapal kapal) {
        if (on&&active&&kapal.getHealth()<kapal.getMaxhealth()/2){
            kapal.setAttack(kapal.getAttack()+2);
            on = false;
        }
        else if(!on&&active&&kapal.getHealth()>=kapal.getMaxhealth()/2){
            kapal.setAttack(kapal.getAttack()-2);
            on = true;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        if (!on){
            kapal.setAttack(kapal.getAttack()-2);
            on = true;
        }
        super.deactivate(kapal);
    }

    @Override
    protected Relic copy() {
        return new VajraRelic();
    }
}
