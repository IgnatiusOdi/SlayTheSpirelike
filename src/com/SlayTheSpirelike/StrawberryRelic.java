package com.SlayTheSpirelike;

public class StrawberryRelic extends Relic{
    public StrawberryRelic() {
        super("Strawberry", "Common","Passive","resources/strawbewwy.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            kapal.setMaxhealth(kapal.getMaxhealth()+2);
            active=false;
        }

    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setMaxhealth(kapal.getMaxhealth()-2);
    }
}
