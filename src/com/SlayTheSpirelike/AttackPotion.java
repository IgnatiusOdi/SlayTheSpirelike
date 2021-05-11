package com.SlayTheSpirelike;

public class AttackPotion extends Potion{
    public AttackPotion() {
        super("Attack Potion", "Buff", 1);
    }

    @Override
    public void activate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()+10);
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()-10);
        active = false;
    }
}
