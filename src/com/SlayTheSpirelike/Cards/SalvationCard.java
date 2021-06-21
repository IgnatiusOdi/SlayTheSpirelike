package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class SalvationCard extends Card {
    public SalvationCard() {
        super("Salvation", "Self", 0);
        this.maxlevel = 1;
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                heal = kapal.getMaxhealth()*30/100;
                restoreHealth(kapal);
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
    public Card copy() {
        return new SalvationCard();
    }
}
