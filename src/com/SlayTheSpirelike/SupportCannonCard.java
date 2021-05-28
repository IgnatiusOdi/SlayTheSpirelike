package com.SlayTheSpirelike;

public class SupportCannonCard extends Card{
    int tt,t;
    public SupportCannonCard() {
        super("Support Cannon", "Self", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            twicetime = tt;
            twice = t;
            drainEnergy(kapal);
            active=false;
        }
    }

    @Override
    public void status() {
        if (level==1){
            tt=2;
            t=2;
            desc = "Your next card \n"+
                    "is played twice";
        }
        else if(level>=2){
            tt=3;
            t=2;
            desc = "Your next two cards \n"+
                    "is played twice";
        }
    }
}
