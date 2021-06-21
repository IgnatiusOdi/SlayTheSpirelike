package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class SteelPotion extends Potion {
    private int ctr;
    public SteelPotion() {
        super("Steel Potion", "Self","Uncommon","resources/SteelPotion.png","On every turn, \n" +
                "gain 1 block");
        ctr=0;
    }
    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setBlock(kapal.getBlock()+1);
            ctr++;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {

    }

    @Override
    public Potion copy() {
        return new SteelPotion();
    }
}
