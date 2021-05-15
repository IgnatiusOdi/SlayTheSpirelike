package com.SlayTheSpirelike;

public class EnergyPotion extends Potion {
    public EnergyPotion() {
        super("Energy Potion", "Self","Uncommon","resources/EnergyPotion.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setEnergy(kapal.getEnergy()+2);
            if (kapal.getEnergy()>kapal.getMaxenergy()){
                kapal.setEnergy(kapal.getMaxenergy());
            }
            active=false;
        }
    }
}
