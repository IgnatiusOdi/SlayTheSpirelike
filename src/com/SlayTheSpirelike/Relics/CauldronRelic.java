package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.*;
import com.SlayTheSpirelike.Potions.InvinciblePotion;
import com.SlayTheSpirelike.Potions.RevivePotion;
import com.SlayTheSpirelike.Potions.SummonPotion;

import java.util.Random;

import static com.SlayTheSpirelike.Statics.*;

public class CauldronRelic extends Relic {
    Random rnd;
    public CauldronRelic() {
        super("Cauldron Relic", "Shop", "One Time", "resources/Cauldron.png","Fill all your empty \n" +
                "potion slots with \n" +
                "random potions (One time)");
        rnd = new Random();
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            while (kapal.getPotionsize()<kapal.getPotionLimit()){
                int p = rnd.nextInt(40)+1;
                if (p<=20){
                    int potion = rnd.nextInt(commonPotion.size());
                    kapal.addPotion(commonPotion.get(potion));
                }
                else if(p<=30){
                    int potion = rnd.nextInt(uncommonPotion.size());
                    kapal.addPotion(uncommonPotion.get(potion));
                }
                else if(p<=35){
                    int potion = rnd.nextInt(rarePotion.size());
                    kapal.addPotion(rarePotion.get(potion));
                }
                else{
                    if (kapal instanceof Aircraft){
                        kapal.addPotion(new SummonPotion());
                    }
                    else if (kapal instanceof Tanker){
                        kapal.addPotion(new InvinciblePotion());
                    }
                    if (kapal instanceof Warship){
                        kapal.addPotion(new RevivePotion());
                    }
                }
            }
            active = false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {

    }

    @Override
    protected Relic copy() {
        return new CauldronRelic();
    }
}
