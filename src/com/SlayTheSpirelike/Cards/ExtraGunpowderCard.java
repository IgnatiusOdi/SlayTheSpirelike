package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class ExtraGunpowderCard extends Card {
    private boolean twiced;
    private boolean used;
    public ExtraGunpowderCard() {
        super("Extra Gundpowder", "Self", 3);
        status();
        twiced = false;
        used = true;
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (used&&active&& kapal.isAlive()){
            if (twice>1) twiced = true;
            for (int i = 0; i < twice; i++) {
                kapal.setAttack(kapal.getAttack()+strength);
                battle.setStrength(battle.getStrength()+strength);
            }
            finish(kapal);
            active=true;
            used=false;
        }
    }

    @Override
    public void status() {
        if (level==1){
            strength=2;
        }
        else if(level>=2){
            strength=3;
        }
        desc = "Gain "+strength+" attack for the \n" +
                "rest of the battle";
    }

    @Override
    public void reactivate() {
        super.reactivate();
        twiced = false;
        used = true;
    }

    @Override
    public Card copy() {
        return new ExtraGunpowderCard();
    }
}
