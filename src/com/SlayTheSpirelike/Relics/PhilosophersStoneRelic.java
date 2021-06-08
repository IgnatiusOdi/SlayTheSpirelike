package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class PhilosophersStoneRelic extends Relic {
    private boolean used;
    public PhilosophersStoneRelic() {
        super("Philosopher's Stone Relic", "Boss Drop", "Start Turn", "resources/PhilosophersStone.png","Gain 1 energy at the \n" +
                "start of each turn. \n" +
                "Enemy start \n" +
                "with 10 weak.");
        used = true;
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setEnergy(kapal.getEnergy()+1);
        }
    }

    @Override
    public void activate(Enemy enemy) {
        if (active&&used){
            enemy.setWeak(enemy.getWeak()+10);
            used=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        super.deactivate(kapal);
        used = true;
    }

    @Override
    protected Relic copy() {
        return new PhilosophersStoneRelic();
    }
}
