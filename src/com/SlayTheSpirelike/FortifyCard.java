package com.SlayTheSpirelike;

public class FortifyCard extends Card{
    public FortifyCard() {
        super("Fortify", "Self", 2);
        status();
    }

    @Override
    public void activate(Kapal k) {
        if (active&&k.isAlive()){
            for (int i = 0; i < twice; i++) {
                k.setBlock(k.getBlock()*2);
            }
            super.activate(k);
        }
    }

    @Override
    public void status() {
        if (level==1){
            cost=2;
        }
        else if(level>=2){
            cost=1;
        }
        desc = "Double your block";
    }
}
