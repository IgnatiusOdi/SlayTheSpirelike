package com.SlayTheSpirelike;

public class SozuRelic extends Relic{
    public SozuRelic() {
        super("Sozu Relic", "Boss Drop", "Start Turn", "resources/Sozu.png");
    }
    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setEnergy(kapal.getEnergy()+1);
        }
    }

    @Override
    public boolean activate() {
        return active;
    }
}
