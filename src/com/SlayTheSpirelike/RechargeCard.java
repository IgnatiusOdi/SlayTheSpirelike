package com.SlayTheSpirelike;

public class RechargeCard extends Card{
    public RechargeCard() {
        super("Recharge", "Self", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                restoreEnergy(kapal);
            }
            super.activate(kapal);
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
