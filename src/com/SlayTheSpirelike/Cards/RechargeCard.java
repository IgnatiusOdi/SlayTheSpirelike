package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class RechargeCard extends Card {
    public RechargeCard() {
        super("Recharge", "Self", 0);
        status();
        singleuse=true;
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                restoreEnergy(kapal);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            energy = 2;
        }
        else if(level>=2){
            energy = 3;
        }
        desc = "Gain "+energy+" energy.\n" +
                "(Single use)";
    }

    @Override
    protected Card copy() {
        return new RechargeCard();
    }
}
