package com.SlayTheSpirelike;

public class LizardTailRelic extends Relic{
    public LizardTailRelic() {
        super("Lizard Tail Relic", "Rare", "Death", "resources/LizardTail.png","When you die, \n" +
                "heal to 50% of your hp \n" +
                "(1 time used per battle)");
    }

    @Override
    public void activate(Kapal kapal) {
        if (!kapal.isAlive()&&active){
            kapal.setHealth(kapal.getMaxhealth()/2);
            active=false;
        }
    }
}
