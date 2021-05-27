package com.SlayTheSpirelike;

public class HelicallCard extends Card{
    public HelicallCard() {
        super("Helicall", "Self", 2);
        status();
    }

    @Override
    public void activate(Kapal k) {
        if (active&&k.isAlive()){
            for (int i = 0; i < twice; i++) {
                k.summon(new HeliSummon());
            }
            super.activate(k);
        }
    }

    @Override
    public void status() {
        if (level==1){
            desc = "Summon 1 heli";
        }
    }

    @Override
    public void upgrade() {

    }
}
