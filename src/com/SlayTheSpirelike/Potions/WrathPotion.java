package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class WrathPotion extends Potion {
    private boolean used;
    public WrathPotion() {
        super("Wrath Potion", "Self","Uncommon","resources/StrengthPotion.png","Gain 3 attack \n" +
                "(remove when battle end)");
        used = true;
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active&&used){
            kapal.setAttack(kapal.getAttack()+3);
            used = false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()-3);
        if (kapal.getAttack()<0){
            kapal.setAttack(0);
        }
    }

    @Override
    public Potion copy() {
        return new WrathPotion();
    }
}
