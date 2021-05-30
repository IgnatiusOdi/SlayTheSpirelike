package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class SteelPotion extends Potion {
    public SteelPotion() {
        super("Steel Potion", "Self","Uncommon","resources/SteelPotion.png","On every turn, \n" +
                "gain 5 block \n" +
                "(remove when battle end)");
    }
    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setBlock(kapal.getBlock()+5);
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setBlock(0);
    }
}
