package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class HeavyArtileryCard extends Card {
    public HeavyArtileryCard() {
        super("Heavy Artilery", "Enemy", 2);
        status();
    }
    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(kapal, enemy);
                applyWeak(enemy);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=4;
            weak=1;
            desc = "Deal 4 damage \n" +
                    "and apply 1 weak";
        }
        else if(level>=2){
            damage=6;
            weak=2;
            desc = "Deal 6 damage \n" +
                    "and apply 2 weak";
        }

    }

    @Override
    public Card copy() {
        return new HeavyArtileryCard();
    }
}


