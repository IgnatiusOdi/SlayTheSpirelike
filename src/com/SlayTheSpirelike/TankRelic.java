package com.SlayTheSpirelike;

public class TankRelic extends Relic{
    public TankRelic() {
        super("Tank Relic", "Common", "Pick Up", "resources/tank.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&&kapal.isAlive()){
            kapal.setFuel(kapal.getFuel()+5);
            if (kapal.getFuel()>kapal.getMaxfuel()){
                kapal.setFuel(kapal.getMaxfuel());
            }
        }
    }
}
