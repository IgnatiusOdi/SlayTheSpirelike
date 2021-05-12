package com.SlayTheSpirelike;

public class RegenerationPotion extends Potion {
    public RegenerationPotion() {
        super("Regeneration Potion", "Self","Uncommon");
    }

    @Override
    public void activate(Kapal kapal) {
        kapal.setHealth(kapal.getHealth()+3);
        if (kapal.getHealth()>kapal.getMaxhealth()){
            kapal.setHealth(kapal.getMaxhealth());
        }
    }
}
