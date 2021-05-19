package com.SlayTheSpirelike;

public class StrawberryRelic extends Relic{
    public StrawberryRelic() {
        super("Strawberry Relic", "Common","Passive","resources/strawbewwy.png","Raise max health \n" +
                "by 2 (Passive)");
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

    }
}
