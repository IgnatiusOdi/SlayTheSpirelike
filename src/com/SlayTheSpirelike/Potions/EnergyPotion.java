package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal.Kapal;

public class EnergyPotion extends Potion {
    public EnergyPotion() {
        super("Energy Potion", "Self","Uncommon");
    }

    @Override
    public void activate(Kapal kapal) {
        kapal.setEnergy(kapal.getEnergy()+2);
        if (kapal.getEnergy()>kapal.getMaxenergy()){
            kapal.setEnergy(kapal.getMaxenergy());
        }
        active=false;
    }
}
