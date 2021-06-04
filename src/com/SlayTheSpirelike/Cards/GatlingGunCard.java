package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class GatlingGunCard extends Card {
    public GatlingGunCard() {
        super("Gatling Gun", "Battle", 2);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
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
            draw=1;
            damage=4;
            desc = "Deal " + damage +" to enemy, \n"+
                    "draw "+draw+" card";
        }
        else if(level>=2){
            draw=2;
            damage=5;
            desc = "Deal " + damage +" to enemy, \n"+
                    "draw "+draw+" cards";
        }
    }

    @Override
    public Card copy() {
        return new GatlingGunCard();
    }
}
