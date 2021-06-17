package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class SupportCannonCard extends Card {
    int tt,t;
    public SupportCannonCard() {
        super("Support Cannon", "Self", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            twicetime = tt;
            twice = t;
            finish(kapal);
            active=false;
        }
    }

    @Override
    public void status() {
        if (level==1){
            tt=2;
            t=2;
            desc = "Your next card \n"+
                    "is played twice";
        }
        else if(level>=2){
            tt=3;
            t=2;
            desc = "Your next two cards \n"+
                    "is played twice";
        }
    }

    @Override
    public Card copy() {
        return new SupportCannonCard();
    }
}
