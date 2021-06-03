package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class PiercingShotCard extends Card {
    public PiercingShotCard() {
        super("Piercing Shot", "Battle", 2);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(kapal, enemy);
                battle.setBleed(battle.getBleed()+bleed);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=4;
            bleed=3;
        }
        else if(level>=2){
            damage=6;
            bleed=3;
        }
        desc = "Deal "+damage+" damage, \n" +
                "apply "+bleed+" bleed \n" +
                "to enemy";
    }

    @Override
    protected Card copy() {
        return new PiercingShotCard();
    }
}
