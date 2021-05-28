package com.SlayTheSpirelike;

public class SalvationCard extends Card{
    public SalvationCard() {
        super("Salvation", "Self", 0);
        status();
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                kapal.setHealth(kapal.getMaxhealth()+30/100);
                if (kapal.getHealth()> kapal.getMaxhealth()){
                    kapal.setHealth(kapal.getMaxhealth());
                }
            }
            finish(kapal);
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
