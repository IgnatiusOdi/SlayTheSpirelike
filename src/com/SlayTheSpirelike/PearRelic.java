package com.SlayTheSpirelike;

public class PearRelic extends Relic{
    public PearRelic() {
        super("Pear", "Uncommon","Passive");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            kapal.setMaxhealth(kapal.getMaxhealth()+4);
            active=false;
        }

    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setMaxhealth(kapal.getMaxhealth()-4);
    }
}
