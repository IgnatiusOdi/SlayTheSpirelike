package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class SalvageCard extends Card {
    public SalvageCard() {
        super("Salvage", "Battle", 2);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(kapal, enemy);
                if (battle.getBleed()>0){
                    restoreEnergy(kapal);
                    battle.draw(draw);
                }
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=3;
            draw=1;
            energy=1;
            desc = "Deal "+damage+" damage, \n" +
                    "if enemy has bleed,\n" +
                    "restore "+energy+" energy,\n" +
                    "draw "+draw+" card";
        }
        else if(level>=2){
            damage=5;
            draw=2;
            energy=1;
            desc = "Deal "+damage+" damage, \n" +
                    "if enemy has bleed,\n" +
                    "restore "+energy+" energy,\n" +
                    "draw "+draw+" cards";
        }
    }

    @Override
    protected Card copy() {
        return new SalvageCard();
    }
}
