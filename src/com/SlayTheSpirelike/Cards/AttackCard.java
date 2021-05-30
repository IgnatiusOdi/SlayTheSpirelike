package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class AttackCard extends Card {
    public AttackCard() {
        super("Attack", "Enemy", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy) {
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
            damage=4;
            desc = "Deal "+damage+" damage \n" +
                    "to enemy";
        }
    }

    @Override
    public void upgrade() {

    }
}
