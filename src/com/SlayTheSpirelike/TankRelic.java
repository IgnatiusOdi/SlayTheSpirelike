package com.SlayTheSpirelike;

public class TankRelic extends Relic{
    public TankRelic() {
        super("Tank Relic", "Common", "Pick Up", "resources/tank.png","Upon pick up, \n" +
                "raise fuel by 5");
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
