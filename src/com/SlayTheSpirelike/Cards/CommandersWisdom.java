package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class CommandersWisdom extends Card {
    public CommandersWisdom() {
        super("Commander's Wisdom", "Battle", 1);
        this.maxlevel = 1;
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                battle.draw(draw);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            draw=2;
        }
        desc = "Draw "+draw+" cards";
    }


    @Override
    public Card copy() {
        return new CommandersWisdom();
    }
}
