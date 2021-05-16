package com.SlayTheSpirelike;


public class AppleJuicePotion extends Potion {
    public AppleJuicePotion() {
        super("Apple Juice", "Self", "Rare","resources/AppleJuice.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active) {
            kapal.setMaxhealth(kapal.getMaxhealth() + 5);
            kapal.setHealth(kapal.getHealth() + 5);
            active = false;
        }
    }
}
