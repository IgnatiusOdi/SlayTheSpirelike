package com.SlayTheSpirelike.Potions;


import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class AppleJuicePotion extends Potion {
    public AppleJuicePotion() {
        super("Apple Juice", "Self", "Rare","resources/AppleJuice.png","Increase max health \n" + "by 5");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active) {
            kapal.setMaxhealth(kapal.getMaxhealth() + 5);
            kapal.setHealth(kapal.getHealth() + 5);
            active = false;
        }
    }
}
