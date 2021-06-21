package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class SniperShotCard extends Card {
    public SniperShotCard() {
        super("Sniper Shot", "Enemy", 2);
        this.maxlevel = 1;
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()) {
            for (int i = 0; i < twice; i++) {
                enemy.setBlock(enemy.getBlock() - 2);
                attack(kapal, enemy);
                enemy.setBlock(enemy.getBlock() + 2);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=2;
            desc = "Bypass 2 block and \n" +
                    "deal "+damage+" to enemy";
        }
    }

    @Override
    public void upgrade() {

    }

    @Override
    public Card copy() {
        return new SniperShotCard();
    }
}
