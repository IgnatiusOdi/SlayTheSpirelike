package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class LoadUpCard extends Card {
    public LoadUpCard() {
        super("Load Up", "Battle", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                for (int j = 0; j < draw; j++) {
                    kapal.addCard(new TorpedoCard());
                }
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            draw=3;
        }
        else if(level>=2){
            draw=4;
        }
        desc = "Add "+draw+" Torpedoes \n" +
                "into your deck";
    }

    @Override
    public Card copy() {
        return new LoadUpCard();
    }
}
