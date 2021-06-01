package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class CombustCard extends Card {
    public CombustCard() {
        super("Combust", "Enemy", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                kapal.setHealth(kapal.getHealth()-heal);
                attack(kapal,enemy);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if(level==1){
            heal = 5;
            damage = 7;
        }
        else if(level>=2){
            heal=4;
            damage=9;
        }
        desc = "Lose "+heal+" health, \n" +
                "deal "+damage+" damage to enemy";
    }
}
