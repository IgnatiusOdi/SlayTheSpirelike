package com.SlayTheSpirelike;

public class MangoRelic extends Relic{
    public MangoRelic() {
        super("Mango Relic", "Rare","Passive","resources/Mango.png","Raise max health \n" +
                "by 6 (Passive)");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setMaxhealth(kapal.getMaxhealth()+6);
            kapal.setHealth(kapal.getHealth()+6);
            active=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {

    }
}
