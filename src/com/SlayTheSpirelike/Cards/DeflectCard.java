package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class DeflectCard extends Card {
    public DeflectCard() {
        super("Deflect", "Self", 0);
        status();
    }
    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&&kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                kapal.setBlock(kapal.getBlock()+block);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            block=2;
        }
        else if(level>=2){
            block=4;
        }
        desc = "Gain "+block+" block";
    }

    @Override
    protected Card copy() {
        return new DeflectCard();
    }
}
