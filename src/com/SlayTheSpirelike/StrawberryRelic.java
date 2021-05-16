package com.SlayTheSpirelike;

public class StrawberryRelic extends Relic{
    public StrawberryRelic() {
        super("Strawberry Relic", "Common","Passive","resources/strawbewwy.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            kapal.setMaxhealth(kapal.getMaxhealth()+2);
            kapal.setHealth(kapal.getHealth()+2);
            active=false;
        }

    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setMaxhealth(kapal.getMaxhealth()-2);
        if (kapal.getHealth()>kapal.getMaxhealth()){
            kapal.setHealth(kapal.getMaxhealth());
        }
        super.deactivate(kapal);
    }
}
