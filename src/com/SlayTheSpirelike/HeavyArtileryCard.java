package com.SlayTheSpirelike;

public class HeavyArtileryCard extends Card{
    public HeavyArtileryCard() {
        super("Heavy Artilery", "Enemy", 2);
        status();
    }
    @Override
    public void activate(Kapal k, Enemy e) {
        if (active&&k.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(k,e);
                e.setAtkhigh(e.getAtkhigh()-weak);
                e.setAtklow(e.getAtklow()-weak);
                if (e.getAtkhigh()<0){
                    e.setAtkhigh(0);
                }
                if (e.getAtklow()<0){
                    e.setAtklow(0);
                }
            }
            super.activate(k,e);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=4;
            weak=2;
        }
        else if(level>=2){
            damage=6;
            weak=3;
        }
        desc = "Deal "+damage+" damage \n" +
                "and apply "+weak+" weak";
    }

}


