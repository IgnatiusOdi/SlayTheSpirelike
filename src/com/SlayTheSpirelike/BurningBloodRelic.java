package com.SlayTheSpirelike;

public class BurningBloodRelic extends Relic{
    public BurningBloodRelic() {
        super("Burning Blood Relic", "Uncommon", "End Battle", "resources/BurningBlood.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setHealth(kapal.getHealth()+2);
            if (kapal.getHealth()>kapal.getMaxhealth()){
                kapal.setHealth(kapal.getMaxhealth());
            }
        }
    }
}
