package com.SlayTheSpirelike;

public class ExplodingPayloadCard extends Card{
    public ExplodingPayloadCard() {
        super("Explosive Payload", "Enemy", 0);
        status();
    }

    @Override
    public void activate(Kapal k, Enemy e) {
        if (active&&k.isAlive()){
            damage*=k.getEnergy();
            cost=k.getEnergy();
            for (int i = 0; i < twice; i++) {
                attack(k,e);
            }
            super.activate(k,e);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=3;
        }
        else if(level>=2){
            damage=5;
        }
        desc = "Deal your remaining\n"
                +"energy x "+damage+" damage \n" +
                "to enemy. Consumes \n" +
                "all remaining energy\n";
    }
}
