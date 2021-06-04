package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class AttackPotion extends Potion {
    public AttackPotion() {
        super("Attack Potion", "Self","Common","resources/AttackPotion.png","Increase attack by 5 \n" +
                "(remove when next turn)");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setAttack(kapal.getAttack()+5);
            active=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()-5);
        if (kapal.getAttack()<0){
            kapal.setAttack(0);
        }
    }

    @Override
    protected Potion copy() {
        return new AttackPotion();
    }
}
