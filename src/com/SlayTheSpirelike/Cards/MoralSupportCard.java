package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class MoralSupportCard extends Card {
    public MoralSupportCard() {
        super("Moral Support", "Battle", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            draw = kapal.summonSize();
            for (int i = 0; i < twice; i++) {
                attack(kapal,enemy);
                battle.draw(draw);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=4;
        }
        else if(level>=2){
            damage=6;
        }
        desc = "Deal " + damage +" to enemy, \n"+
                "draw 1 card for \n" +
                "each heli you have";
    }
}
