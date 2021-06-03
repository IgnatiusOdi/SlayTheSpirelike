package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class SupportFlareCard extends Card {
    public SupportFlareCard() {
        super("Support Flare", "Battle", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(kapal,enemy);
                summon(kapal);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            summon=1;
            damage=3;
        }
        else if (level>=2){
            summon=2;
            damage=4;
        }
        desc = "Deal "+damage+" to enemy,\n" +
                "summon "+summon+" heli";
    }

    @Override
    protected Card copy() {
        return new SupportFlareCard();
    }
}
