package com.SlayTheSpirelike;

public class CannontizerRelic extends Relic{
    public CannontizerRelic() {
        super("Cannontizer Relic", "Common", "Damage", "resources/cannon.png","Increase your attack \n" +
                "by 1 (Passive");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            kapal.setAttack(kapal.getAttack()+1);
            active=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {

    }
}
