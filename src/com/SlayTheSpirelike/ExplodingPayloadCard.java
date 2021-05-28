package com.SlayTheSpirelike;

public class ExplodingPayloadCard extends Card{
    public ExplodingPayloadCard() {
        super("Explosive Payload", "Enemy", 0);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy) {
        if (active&& kapal.isAlive()){
            damage*= kapal.getEnergy();
            cost= kapal.getEnergy();
            for (int i = 0; i < twice; i++) {
                attack(kapal, enemy);
            }
            super.activate(kapal, enemy);
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
