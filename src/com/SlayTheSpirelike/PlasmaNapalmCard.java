package com.SlayTheSpirelike;

public class PlasmaNapalmCard extends Card{
    public PlasmaNapalmCard() {
        super("Plasma Napalm", "Enemy", 2);
        status();
    }
    @Override
    public void activate(Kapal k, Enemy e) {
        if (active&&k.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(k,e);
            }
            super.activate(k,e);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=6;
        }
        else if(level>=2){
            damage=10;
        }
        desc = "Deal "+damage+" damage \n" +
                "to enemy";
    }
}
