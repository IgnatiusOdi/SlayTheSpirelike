package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class DefendCard extends Card {
    public DefendCard() {
        super("Defend", "Self", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                kapal.setBlock(kapal.getBlock()+block);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            block=2;
        }
        else if(level>=2){
            block=4;
        }
        desc = "Gain "+block+" block";
    }

    @Override
    public Card copy() {
        return new DefendCard();
    }
}
