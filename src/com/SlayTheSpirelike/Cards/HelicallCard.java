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
                kapal.summon(new HeliSummon());
                kapal.summon(new HeliSummon());
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
        desc = "Summon 2 heli";
    }

}
