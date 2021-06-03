package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class StrategicShotCard extends Card {
    public StrategicShotCard() {
        super("Strategic Shot", "Battle", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                battle.setBleed(battle.getBleed()*2);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            cost=1;
        }
        else if(level>=2){
            cost=0;
        }
        desc = "Double enemy's bleed";
    }

    @Override
    protected Card copy() {
        return new StrategicShotCard();
    }
}
