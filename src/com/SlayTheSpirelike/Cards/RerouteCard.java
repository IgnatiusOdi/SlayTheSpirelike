package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Kapal;

public class RerouteCard extends Card {
    public RerouteCard() {
        super("Reroute", "Self", 0);
        status();
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                restoreEnergy(kapal);
                kapal.setHealth(kapal.getHealth()-2);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            energy=2;
        }
        else if(level>=2){
            energy=3;
        }
        desc = "Restore "+energy+" energy \n"
        +", lose 2 health";
    }
}
