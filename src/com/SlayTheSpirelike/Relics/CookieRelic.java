package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class CookieRelic extends Relic {
    public CookieRelic() {
        super("Cookie Relic", "Shop", "One Time", "resources/cookie.png","Raise max health \n" +
                "by 5 and heal all \n" +
                "of your health (One time)");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setMaxhealth(kapal.getMaxhealth()+5);
            kapal.setHealth(kapal.getMaxhealth());
            active=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {

    }
}
