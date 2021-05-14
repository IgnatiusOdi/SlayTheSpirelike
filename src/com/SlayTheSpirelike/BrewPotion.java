package com.SlayTheSpirelike;

import java.util.Random;

import static com.SlayTheSpirelike.Statics.*;

public class BrewPotion extends Potion{
    Random rnd;
    public BrewPotion() {
        super("Brew Potion", "Kapal", "Rare", "resources/BrewPotion.png");
        rnd = new Random();
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            while (kapal.getPotionsize()<kapal.potionLimit){
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
            }
            active = false;
        }
    }
}
