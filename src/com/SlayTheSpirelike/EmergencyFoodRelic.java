package com.SlayTheSpirelike;

public class EmergencyFoodRelic extends Relic{
    public EmergencyFoodRelic() {
        super("Emergency Food Relic", "Common", "Health", "resources/emergency food.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&kapal.getHealth()<=kapal.getMaxhealth()/2&&active){
            kapal.setHealth(kapal.getHealth()+5);
            active=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        active=true;
    }
}
