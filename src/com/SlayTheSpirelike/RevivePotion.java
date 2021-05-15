package com.SlayTheSpirelike;

public class RevivePotion extends Potion{
    public RevivePotion() {
        super("Revive Potion", "Special", "Special", "resources/RevivePotion.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (!kapal.isAlive()&&active){
            kapal.setHealth(kapal.getMaxhealth()*30/100);
            active=false;
        }
    }
}
