package com.SlayTheSpirelike;

public class HeartChipRelic extends Relic{
    public HeartChipRelic() {
        super("HeartChip", "Special","Passive","resources/tankerrelic.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            kapal.setMaxhealth(kapal.getMaxhealth()+8);
            active=false;
        }

    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setMaxhealth(kapal.getMaxhealth()-8);
    }
}
