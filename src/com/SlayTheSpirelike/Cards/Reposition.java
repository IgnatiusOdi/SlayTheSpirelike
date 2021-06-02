package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class Reposition extends Card {
    public Reposition() {
        super("Reposition", "Self", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                battle.draw(draw);
                kapal.setBlock(kapal.getBlock()+block);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            draw=1;
            block=3;
        }
        else if(level>=2){
            draw=2;
            block=3;
        }
        desc = "Gain " + block +" block, \n"+
                "draw "+draw+" cards";
    }
}
