package com.SlayTheSpirelike;

public class WrathPotion extends Potion {
    private boolean used;
    public WrathPotion() {
        super("Wrath Potion", "Self","Uncommon","resources/StrengthPotion.png");
        used = true;
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active&&used){
            kapal.setAttack(kapal.getAttack()+5);
            used = false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setAttack(kapal.getAttack()-5);
        if (kapal.getAttack()<0){
            kapal.setAttack(0);
        }
    }
}
