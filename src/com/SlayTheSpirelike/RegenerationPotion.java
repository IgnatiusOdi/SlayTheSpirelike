package com.SlayTheSpirelike;

public class RegenerationPotion extends Potion {
    public RegenerationPotion() {
        super("Regeneration Potion", "Self","Uncommon","resources/RegenPotion.png","Every turn, \n" +
                "heal 3 health");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setHealth(kapal.getHealth()+3);
            if (kapal.getHealth()>kapal.getMaxhealth()){
                kapal.setHealth(kapal.getMaxhealth());
            }
        }

    }
}
