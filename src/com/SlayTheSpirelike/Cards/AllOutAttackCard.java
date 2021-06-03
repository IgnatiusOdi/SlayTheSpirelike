package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class AllOutAttackCard extends Card {
    private int tempdamage;
    public AllOutAttackCard() {
        super("All Out Attack", "Enemy", 2);
        this.tempdamage = 0;
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            damage = tempdamage*kapal.summonSize();
            for (int i = 0; i < twice; i++) {
                attack(kapal, enemy);
            }
            finish(kapal);
            kapal.desummon();
        }
    }

    @Override
    public void status() {
        if (level==1){
            tempdamage=8;
        }
        else if(level>=2){
            tempdamage=10;
        }
        desc = "For each heli, \n" +
                "deal "+tempdamage+" damage. \n" +
                "Desummon all heli.";
    }

    @Override
    protected Card copy() {
        return new AllOutAttackCard();
    }
}
