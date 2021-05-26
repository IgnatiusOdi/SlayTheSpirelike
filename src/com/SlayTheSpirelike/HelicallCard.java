package com.SlayTheSpirelike;

public class HelicallCard extends Card{
    public HelicallCard() {
        super("Helicall", "Self", 2);
        status();
    }

    @Override
    public void activate(Kapal k) {
        super.activate(k);
        k.summon(new HeliSummon());
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
