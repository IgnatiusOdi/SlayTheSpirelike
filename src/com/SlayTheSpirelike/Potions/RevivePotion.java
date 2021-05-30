package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class RevivePotion extends Potion {
    public RevivePotion() {
        super("Revive Potion", "Special", "Special", "resources/RevivePotion.png","When you die, \n" +
                "heal to 30% of \n" +
                "your max health\n" +
                "(Warship only)");
    }

    @Override
    public void activate(Kapal kapal) {
        if (!kapal.isAlive()&&active){
            kapal.setHealth(kapal.getMaxhealth()*30/100);
            active=false;
        }
    }
}
