package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class FortifyCard extends Card {
    public FortifyCard() {
        super("Fortify", "Self", 2);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                kapal.setBlock(kapal.getBlock()*2);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            cost=2;
        }
        else if(level>=2){
            cost=1;
        }
        desc = "Double your block";
    }

    @Override
    protected Card copy() {
        return new FortifyCard();
    }
}
