package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class KamikazeCard extends Card {
    public KamikazeCard() {
        super("Kamikaze", "Battle", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                if (kapal.summonSize()>0){
                    battle.draw(draw);
                    kapal.destroySummon();
                }
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            draw=2;
        }
        else if(level>=2){
            draw=3;
        }
        desc = "Destroy 1 heli\n" +
                "Draw "+draw+" cards\n" +
                "(Must have heli)";
    }
}
