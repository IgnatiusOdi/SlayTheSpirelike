package com.SlayTheSpirelike;

public class SummonPotion extends Potion{
    public SummonPotion() {
        super("Summon Potion", "Special", "Special", "resources/summonPotion.png","Summon 2 helis \n" +
                "to assist you\n" +
                "(Aircraft only)");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&&kapal.isAlive()){
            kapal.summon(new HeliSummon());
            kapal.summon(new HeliSummon());
            active=false;
        }
    }
}
