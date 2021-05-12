package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal.Kapal;

public class AttackPotion extends Potion {
    public AttackPotion() {
        super("Attack Potion", "Self","Common");
    }

    @Override
    public void activate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()+10);
        active=false;
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()-10);
        if (kapal.getAttack()<0){
            kapal.setAttack(0);
        }
    }
}
