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
            weak=2;
        }
        else if(level>=2){
            damage=6;
            weak=3;
        }
        desc = "Deal "+damage+" damage \n" +
                "and apply "+weak+" weak";
    }

}


