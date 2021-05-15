package com.SlayTheSpirelike;

public class LizardTailRelic extends Relic{
    public LizardTailRelic() {
        super("Lizard Tail Relic", "Rare", "Death", "resources/LizardTail.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (!kapal.isAlive()&&active){
            kapal.setHealth(kapal.getMaxhealth()/2);
            active=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        active=true;
    }
}
