package com.SlayTheSpirelike;

public class SteelPotion extends Potion {
    public SteelPotion() {
        super("Steel Potion", "Self","Uncommon","resources/SteelPotion.png");
    }
    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setBlock(kapal.getBlock()+10);
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setBlock(0);
    }
}
