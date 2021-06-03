package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class ExplodingPayloadCard extends Card {
    private int tempdamage;
    public ExplodingPayloadCard() {
        super("Explosive Payload", "Enemy", 0);
        this.tempdamage = 0;
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            damage = tempdamage*kapal.getEnergy();
            cost = kapal.getEnergy();
            for (int i = 0; i < twice; i++) {
                attack(kapal, enemy);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            tempdamage=3;
        }
        else if(level>=2){
            tempdamage=5;
        }
        desc = "Deal your remaining\n"
                +"energy x "+tempdamage+" damage \n" +
                "to enemy. Consumes \n" +
                "all remaining energy\n";
    }

    @Override
    protected Card copy() {
        return new ExplodingPayloadCard();
    }
}
