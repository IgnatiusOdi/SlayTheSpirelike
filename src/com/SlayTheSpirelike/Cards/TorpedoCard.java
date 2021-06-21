package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class TorpedoCard extends Card {
    public TorpedoCard() {
        super("Torpedo", "Enemy", 0);
        this.maxlevel = 1;
        status();
        dispose=true;
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(kapal, enemy);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=2;
            desc = "Deal "+damage+" damage \n" +
                    "to enemy. (Remove after use)";
        }
    }

    @Override
    public void upgrade() {

    }

    @Override
    public Card copy() {
        return new TorpedoCard();
    }
}
