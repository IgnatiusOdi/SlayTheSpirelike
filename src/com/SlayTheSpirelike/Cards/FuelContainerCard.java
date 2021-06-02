package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class FuelContainerCard extends Card {
    public FuelContainerCard() {
        super("Fuel Container", "Self", 0);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                restoreEnergy(kapal);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            energy = 1;
        }
        else if(level>=2){
            energy = 2;
        }
        desc = "Gain "+energy+" energy.";
    }
}
