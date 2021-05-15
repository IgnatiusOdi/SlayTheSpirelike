package com.SlayTheSpirelike;

public class MangoRelic extends Relic{
    public MangoRelic() {
        super("Mango Relic", "Rare","Passive","resources/Mango.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            kapal.setMaxhealth(kapal.getMaxhealth()+6);
            active=false;
        }

    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setMaxhealth(kapal.getMaxhealth()-6);
    }
}
