package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Kapal;

public class SalvationCard extends Card {
    public SalvationCard() {
        super("Salvation", "Self", 0);
        status();
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                // TODO: 31/05/2021 abraham arthur fix this pls ty
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
