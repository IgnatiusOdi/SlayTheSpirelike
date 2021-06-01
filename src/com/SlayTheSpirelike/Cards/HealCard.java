package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class HealCard extends Card {
    public HealCard() {
        super("Heal", "Self", 0);
        status();
        singleuse=true;
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                restoreHealth(kapal);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if(level==1){
            heal = 5;
        }
        else if(level>=2){
            heal = 7;
        }
        desc = "Heal "+heal+" health. \n" +
                "(Single use)";
    }
}
