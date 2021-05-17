package com.SlayTheSpirelike;

public class PhilosophersStoneRelic extends Relic{
    public PhilosophersStoneRelic() {
        super("Philosopher's Stone Relic", "Boss Drop", "Start Turn", "resources/PhilosophersStone.png","Gain 1 energy at the \n" +
                "start of each turn. \n" +
                "All enemies start \n" +
                "with 1 attack.");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setEnergy(kapal.getEnergy()+1);
        }
    }

    @Override
    public void activate(Enemy enemy) {
        if (active){
            enemy.setAtkhigh(1);
            enemy.setAtklow(1);
        }
    }
}
