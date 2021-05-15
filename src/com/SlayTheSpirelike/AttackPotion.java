package com.SlayTheSpirelike;

public class AttackPotion extends Potion {
    public AttackPotion() {
        super("Attack Potion", "Self","Common","resources/AttackPotion.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setAttack(kapal.getAttack()+8);
            active=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()-8);
        if (kapal.getAttack()<0){
            kapal.setAttack(0);
        }
    }
}
