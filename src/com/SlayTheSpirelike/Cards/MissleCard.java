package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class MissleCard extends Card {
    public MissleCard() {
        super("Missle", "Enemy", 3);
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
            damage=13;
        }
        else if(level>=2){
            damage=17;
        }
        desc = "Deal "+damage+" damage \n" +
                "to enemy";
    }

    @Override
    public Card copy() {
        return new MissleCard();
    }
}
