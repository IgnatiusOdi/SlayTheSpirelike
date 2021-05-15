package com.SlayTheSpirelike;

public class PhilosophersStoneRelic extends Relic{
    public PhilosophersStoneRelic() {
        super("Philosopher's Stone Relic", "Boss Drop", "Start Turn", "resources/PhilosophersStone.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setEnergy(kapal.getEnergy()+1);
        }
    }
}
