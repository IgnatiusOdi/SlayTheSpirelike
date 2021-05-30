package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.HeliSummon;
import com.SlayTheSpirelike.Kapal;

public class HelicallCard extends Card {
    public HelicallCard() {
        super("Helicall", "Self", 2);
        status();
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                kapal.summon(new HeliSummon());
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            desc = "Summon 1 heli";
        }
    }

    @Override
    public void upgrade() {

    }
}
