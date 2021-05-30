package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.*;
import com.SlayTheSpirelike.Cards.GatlingGunCard;
import com.SlayTheSpirelike.Cards.HelicallCard;
import com.SlayTheSpirelike.Cards.SalvationCard;
import com.SlayTheSpirelike.Potions.InvinciblePotion;
import com.SlayTheSpirelike.Potions.RevivePotion;
import com.SlayTheSpirelike.Potions.SummonPotion;

import java.util.Random;

import static com.SlayTheSpirelike.Statics.*;
import static com.SlayTheSpirelike.Statics.rarePotion;

public class StarterPackRelic extends Relic {
    Random rnd;
    public StarterPackRelic() {
        super("Starter Pack Relic", "Boss Drop", "One Time", "resources/staterpack.png","Obtain 1 random potion, \n" +
                "gain 10 coins, \n" +
                "raise max health by 3, \n" +
                "obtain 1 random card (One time)");
        rnd = new Random();
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
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
                else if (kapal instanceof Warship){
                    kapal.addPotion(new RevivePotion());
                }
            }

            kapal.setCoin(kapal.getCoin()+10);
            kapal.setMaxhealth(kapal.getMaxhealth()+3);
            kapal.setHealth(kapal.getHealth()+3);

            int card = rnd.nextInt(cards.size()+1);
            if (card==cards.size()){
                if (kapal instanceof Aircraft){
                    kapal.addCard(new HelicallCard());
                }
                else if (kapal instanceof Tanker){
                    kapal.addCard(new SalvationCard());
                }
                else if (kapal instanceof Warship){
                    kapal.addCard(new GatlingGunCard());
                }
            }
            else{
                kapal.addCard(cards.get(card));
            }

            active=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {

    }
}
