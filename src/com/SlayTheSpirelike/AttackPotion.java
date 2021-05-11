package com.SlayTheSpirelike;

public class AttackPotion extends Potion{
    public AttackPotion() {
        super("Attack Potion", "Buff");
    }

    @Override
    public void activate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()+10);
        active=false;
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()-10);
    }
}
