package com.SlayTheSpirelike;

public class HeartChipRelic extends Relic{
    public HeartChipRelic() {
        super("HeartChip", "Passive","Passive","resources/tankerrelic.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            kapal.setMaxhealth(kapal.getMaxhealth()+8);
            kapal.setHealth(kapal.getHealth()+8);
            active=false;
        }

    }

    @Override
    public void deactivate(Kapal kapal) {

    }
}
