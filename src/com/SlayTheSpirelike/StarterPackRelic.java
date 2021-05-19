package com.SlayTheSpirelike;

import java.util.Random;

import static com.SlayTheSpirelike.Statics.*;
import static com.SlayTheSpirelike.Statics.rarePotion;

public class StarterPackRelic extends Relic{
    Random rnd;
    public StarterPackRelic() {
        super("Starter Pack Relic", "Boss Drop", "???", "resources/staterpack.png","Obtain 1 random potion, \n" +
                "gain 10 coins, \n" +
                "raise max health by 3, \n" +
                "obtain 1 random card (One time)");
        rnd = new Random();
    }

    @Override
    public void activate(Kapal kapal) {
        if (active){
            int p = rnd.nextInt(40)+1;
            if (p<=20){
                int potion = rnd.nextInt(commonPotion.size());
                kapal.obtainPotion(commonPotion.get(potion));
            }
            else if(p<=30){
                int potion = rnd.nextInt(uncommonPotion.size());
                kapal.obtainPotion(uncommonPotion.get(potion));
            }
            else if(p<=35){
                int potion = rnd.nextInt(rarePotion.size());
                kapal.obtainPotion(rarePotion.get(potion));
            }
            else{
                if (kapal instanceof Aircraft){
                    kapal.obtainPotion(new SummonPotion());
                }
                else if (kapal instanceof Tanker){
                    kapal.obtainPotion(new InvinciblePotion());
                }
                if (kapal instanceof Warship){
                    kapal.obtainPotion(new RevivePotion());
                }
            }

            kapal.setCoin(kapal.getCoin()+10);
            kapal.setMaxhealth(kapal.getMaxhealth()+3);
            kapal.setHealth(kapal.getHealth()+3);
        }
    }

    @Override
    public void deactivate(Kapal kapal) {

    }
}
