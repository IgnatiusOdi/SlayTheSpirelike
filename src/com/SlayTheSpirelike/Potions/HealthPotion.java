package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal.*;

public class HealthPotion extends Potion {
    public HealthPotion() {
        super("Health Potion", "Self","Common");
    }

    @Override
    public void activate(Kapal kapal) {
        kapal.setHealth(kapal.getHealth()+(kapal.getMaxhealth()*20/100));
        if (kapal.getHealth()>kapal.getMaxhealth()){
            kapal.setHealth(kapal.getMaxhealth());
        }
        active = false;
    }
}
