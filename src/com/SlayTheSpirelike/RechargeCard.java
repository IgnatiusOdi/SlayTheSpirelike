package com.SlayTheSpirelike;

public class RechargeCard extends Card{
    public RechargeCard() {
        super("Recharge", "Self", 1);
        status();
    }

    @Override
    public void activate(Kapal k) {
        if (active&&k.isAlive()){
            for (int i = 0; i < twice; i++) {
                restoreEnergy(k);
            }
            super.activate(k);
        }
    }

    @Override
    public void status() {
        if (level==1){
            energy = 2;
        }
        else if(level>=2){
            energy = 3;
        }
        desc = "Gain "+energy+" energy";
    }
}
