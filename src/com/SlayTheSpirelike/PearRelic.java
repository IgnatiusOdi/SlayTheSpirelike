package com.SlayTheSpirelike;

public class PearRelic extends Relic{
    public PearRelic() {
        super("Pear Relic", "Uncommon","Passive","resources/pear.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            kapal.setMaxhealth(kapal.getMaxhealth()+4);
            kapal.setHealth(kapal.getHealth()+4);
            active=false;
        }

    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setMaxhealth(kapal.getMaxhealth()-4);
        if (kapal.getHealth()>kapal.getMaxhealth()){
            kapal.setHealth(kapal.getMaxhealth());
        }
        super.deactivate(kapal);
    }
}
