package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class InspiringShotCard extends Card {
    public InspiringShotCard() {
        super("Inspiring Shot", "Battle", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(kapal, enemy);
                battle.draw(draw);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=3;
            draw=1;
        }
        else if(level>=2){
            damage=5;
            draw=1;
        }
        desc = "Deal "+damage+" damage \n" +
                "to enemy and \n" +
                "draw "+draw+" card";
    }

    @Override
    protected Card copy() {
        return new InspiringShotCard();
    }
}
