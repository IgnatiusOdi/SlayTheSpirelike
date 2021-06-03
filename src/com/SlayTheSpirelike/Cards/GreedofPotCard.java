package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class GreedofPotCard extends Card {
    public GreedofPotCard() {
        super("Greed of Pot", "Battle", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                battle.draw(draw);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            draw=2;
        }
        else if(level>=2){
            draw=3;
        }
        desc = "Draw "+draw+" cards";
    }

    @Override
    protected Card copy() {
        return new GreedofPotCard();
    }
}
