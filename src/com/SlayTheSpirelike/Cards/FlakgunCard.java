package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class FlakgunCard extends Card {
    public FlakgunCard() {
        super("Flakgun", "Enemy", 2);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(kapal, enemy);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=5;
        }
        else if(level>=2){
            damage=7;
        }
        desc = "Deal "+damage+" damage \n" +
                "to enemy";
    }

    @Override
    public Card copy() {
        return new FlakgunCard();
    }
}
