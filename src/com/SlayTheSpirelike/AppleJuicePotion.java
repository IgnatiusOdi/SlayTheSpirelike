package com.SlayTheSpirelike;

public class AppleJuicePotion extends Potion {
    public AppleJuicePotion() {
        super("Apple Juice", "Self", "Rare");
    }

    @Override
    public void activate(Kapal kapal) {
        kapal.setMaxhealth(kapal.getMaxhealth()+5);
        active=false;
    }
}
