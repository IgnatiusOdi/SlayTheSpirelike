package com.SlayTheSpirelike;

public class StonedRelic extends Relic{
    public StonedRelic() {
        super("Stoned Relic", "Common", "Combat Start", "resources/stoned.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setBlock(kapal.getBlock()+1);
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setBlock(0);
        active=true;
    }
}
