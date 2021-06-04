package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class HelicallCard extends Card {
    public HelicallCard() {
        super("Helicall", "Self", 2);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                summon(kapal);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            cost = 1;
        }
        else if (level>=2){
            cost = 2;
        }
        desc = "Summon "+summon+" heli";
    }

    @Override
    public Card copy() {
        return new HelicallCard();
    }
}
