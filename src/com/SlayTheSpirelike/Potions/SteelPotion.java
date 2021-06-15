package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class SteelPotion extends Potion {
    private int ctr;
    public SteelPotion() {
        super("Steel Potion", "Self","Uncommon","resources/SteelPotion.png","On every turn, \n" +
                "gain 5 block \n" +
                "(remove when battle end)");
        ctr=0;
    }
    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setBlock(kapal.getBlock()+5);
            ctr++;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setBlock(kapal.getBlock()-(5*ctr));
        if (kapal.getBlock()<0){
            kapal.setBlock(0);
        }
    }

    @Override
    public Potion copy() {
        return new SteelPotion();
    }
}
