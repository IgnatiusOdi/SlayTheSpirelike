package com.SlayTheSpirelike;

public class RerouteCard extends Card{
    public RerouteCard() {
        super("Reroute", "Self", 0);
        status();
    }

    @Override
    public void activate(Kapal k) {
        if (active&&k.isAlive()){
            for (int i = 0; i < twice; i++) {
                restoreEnergy(k);
                k.setHealth(k.getHealth()-2);
            }
            super.activate(k);
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
