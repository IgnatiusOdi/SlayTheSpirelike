package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class RocketSalvoCard extends Card {
    public RocketSalvoCard() {
        super("Rocket Salvo", "Enemy", 0);
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
            damage=1;
            weak=1;
        }
        else if(level>=2){
            damage=1;
            weak=2;
        }
        desc = "Deal "+damage+" damage \n" +
                "and apply "+weak+" weak";
    }

    @Override
    protected Card copy() {
        return new RocketSalvoCard();
    }
}
