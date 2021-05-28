package com.SlayTheSpirelike;

public class DefendCard extends Card{
    public DefendCard() {
        super("Defend", "Self", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                kapal.setBlock(kapal.getBlock()+block);
            }
            super.activate(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            block=2;
            desc = "Gain "+block+" block";
        }
    }

    @Override
    public void upgrade() {

    }
}
