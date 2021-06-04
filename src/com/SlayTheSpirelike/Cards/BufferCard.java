package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class BufferCard extends Card {
    public BufferCard() {
        super("Buffer", "Self", 2);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                battle.setInvincible(true);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if(level==1){
            cost = 2;
        }
        else if(level>=2){
            cost = 1;
        }
        desc = "Prevent the next time \n" +
                "you would lose health";
    }

    @Override
    public Card copy() {
        return new BufferCard();
    }
}
