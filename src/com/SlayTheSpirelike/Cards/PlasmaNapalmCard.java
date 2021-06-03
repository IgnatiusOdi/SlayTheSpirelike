package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class PlasmaNapalmCard extends Card {
    public PlasmaNapalmCard() {
        super("Plasma Napalm", "Enemy", 2);
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
            damage=6;
        }
        else if(level>=2){
            damage=10;
        }
        desc = "Deal "+damage+" damage \n" +
                "to enemy";
    }

    @Override
    protected Card copy() {
        return new PlasmaNapalmCard();
    }
}
