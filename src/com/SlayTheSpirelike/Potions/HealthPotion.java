package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class HealthPotion extends Potion {
    public HealthPotion() {
        super("Health Potion", "Self","Common","resources/HealthPotion.png","Heal for 20% of your max hp");
    }

    @Override
    public void activate(Kapal kapal) {
        if(kapal.isAlive()&&active){
            kapal.setHealth(kapal.getHealth()+(kapal.getMaxhealth()*20/100));
            if (kapal.getHealth()>kapal.getMaxhealth()){
                kapal.setHealth(kapal.getMaxhealth());
            }
            active = false;
        }
    }

    @Override
    public Potion copy() {
        return new HealthPotion();
    }
}
