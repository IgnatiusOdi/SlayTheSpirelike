package com.SlayTheSpirelike;

public class SalvationCard extends Card{
    public SalvationCard() {
        super("Salvation", "Self", 0);
        status();
    }

    @Override
    public void activate(Kapal k) {
        if (active&&k.isAlive()){
            for (int i = 0; i < twice; i++) {
                k.setHealth(k.getMaxhealth()+30/100);
                if (k.getHealth()>k.getMaxhealth()){
                    k.setHealth(k.getMaxhealth());
                }
            }
            super.activate(k);
        }
    }

    @Override
    public void status() {
        if (level==1){
            desc = "Heal 30% of max health";
        }
    }

    @Override
    public void upgrade() {

    }
}
