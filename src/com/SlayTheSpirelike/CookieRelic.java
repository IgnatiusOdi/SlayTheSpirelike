package com.SlayTheSpirelike;

public class CookieRelic extends Relic{
    public CookieRelic() {
        super("Cookie Relic", "Shop", "???", "resources/cookie.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setMaxhealth(kapal.getMaxhealth()+5);
            kapal.setHealth(kapal.getMaxhealth());
            active=false;
        }
    }
}
