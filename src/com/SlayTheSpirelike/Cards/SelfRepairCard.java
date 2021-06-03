package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class SelfRepairCard extends Card {
    public SelfRepairCard() {
        super("Self Repair", "Self", 1);
        status();
        singleuse=true;
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                battle.setHeal(battle.getHeal()+heal);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if(level==1){
            heal = 5;
        }
        else if(level>=2){
            heal = 7;
        }
        desc = "At end of battle, \n" +
                "heal "+heal+" health. \n" +
                "(Single use)";
    }

    @Override
    protected Card copy() {
        return new SelfRepairCard();
    }
}
