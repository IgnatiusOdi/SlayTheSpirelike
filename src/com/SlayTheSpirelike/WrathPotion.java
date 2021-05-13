package com.SlayTheSpirelike;

public class WrathPotion extends Potion {
    private boolean used;
    public WrathPotion() {
        super("Wrath Potion", "Self","Uncommon","resources/StrengthPotion.png");
        used = true;
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
