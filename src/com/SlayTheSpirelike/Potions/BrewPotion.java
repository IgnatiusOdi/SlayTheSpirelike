package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.*;

import java.util.Random;

import static com.SlayTheSpirelike.Statics.*;

public class BrewPotion extends Potion {
    Random rnd;
    public BrewPotion() {
        super("Brew Potion", "Kapal", "Rare", "resources/BrewPotion.png","Fill all your \n" +
                "empty potion slots \n" +
                "with random potions");
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
    protected Potion copy() {
        return new BrewPotion();
    }
}
