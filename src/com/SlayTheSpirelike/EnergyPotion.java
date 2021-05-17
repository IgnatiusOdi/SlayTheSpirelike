package com.SlayTheSpirelike;

public class EnergyPotion extends Potion {
    public EnergyPotion() {
        super("Energy Potion", "Self","Uncommon","resources/EnergyPotion.png","Gain 2 energy");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setEnergy(kapal.getEnergy()+2);
            active=false;
        }
    }
}
