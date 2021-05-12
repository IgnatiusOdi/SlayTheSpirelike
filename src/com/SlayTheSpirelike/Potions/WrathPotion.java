package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal.Kapal;

public class WrathPotion extends Potion {
    boolean used = true;
    public WrathPotion() {
        super("Wrath Potion", "Self","Uncommon");
    }

    @Override
    public void activate(Kapal kapal) {
        if (used){
            kapal.setAttack(kapal.getAttack()+10);
            used = false;
        }
        used=false;
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()-10);
        if (kapal.getAttack()<0){
            kapal.setAttack(0);
        }
    }
}
