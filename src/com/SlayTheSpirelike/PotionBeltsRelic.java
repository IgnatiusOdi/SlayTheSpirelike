package com.SlayTheSpirelike;

public class PotionBeltsRelic extends Relic{
    public PotionBeltsRelic() {
        super("Potion Belts Relic", "Uncommon", "Pick Up", "resources/PotionBelt.png");
    }

    @Override
    public void activate(Kapal kapal) {
        kapal.setPotionLimit(kapal.getPotionLimit()+2);
    }
}
