package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class OneforAllCard extends Card {
    public OneforAllCard() {
        super("One for All", "Enemy", 2);
        this.maxlevel = 99;
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
        damage=7;
        for (int i = 0; i < level-1; i++) {
            damage+=2+i;
        }
        desc = "Deal "+damage+" damage \n" +
                "to enemy. Can be \n" +
                "upgraded until lv 99";
    }

    @Override
    public Card copy() {
        return new OneforAllCard();
    }
}
