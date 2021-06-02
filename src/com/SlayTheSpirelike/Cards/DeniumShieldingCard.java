package com.SlayTheSpirelike.Cards;

import com.SlayTheSpirelike.*;

public class DeniumShieldingCard extends Card {
    public DeniumShieldingCard() {
        super("Denium Shielding", "Self", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                kapal.setBlock(kapal.getBlock()+block);
                battle.setEnergyplus(battle.getEnergyplus()+energy);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            block=4;
            energy=1;
        }
        else if(level>=2){
            block=6;
            energy=1;
        }
        desc = "Gain "+block+" block,\n" +
                "next turn restore "+energy+" energy";
    }
}
