package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Card;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class OverclockingReactorCard extends Card {
    private boolean twiced;
    public OverclockingReactorCard() {
        super("Overclocking Reactor", "Self", 0);
        status();
        twiced = false;
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            if (twice>1) twiced = true;
            for (int i = 0; i < twice; i++) {
                kapal.setAttack(kapal.getAttack()+strength);
                battle.setStrengthtemp(battle.getStrengthtemp()+strength);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            strength=2;
        }
        else if(level>=2){
            strength=4;
        }
        desc = "Gain "+strength+" attack \n" +
                "for one turn";
    }

    @Override
    public void reactivate() {
        super.reactivate();
        twiced=false;
    }
}
