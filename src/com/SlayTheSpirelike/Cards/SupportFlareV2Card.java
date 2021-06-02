package com.SlayTheSpirelike.Cards;
import com.SlayTheSpirelike.*;

public class SupportFlareV2Card extends Card {
    public SupportFlareV2Card() {
        super("Support Flare V2", "Battle", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(kapal,enemy);
                summon(kapal);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            summon=1;
            damage=5;
        }
        else if (level>=2){
            summon=2;
            damage=5;
        }
        desc = "Deal "+damage+" to enemy,\n" +
                "summon "+summon+" heli";
    }
}
