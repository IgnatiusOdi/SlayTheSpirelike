package com.SlayTheSpirelike;

public class GatlingGunCard extends Card{
    public GatlingGunCard() {
        super("Gatling Gun", "Enemy", 2);
    }

    @Override
    public void activate(Kapal k, Enemy e) {
        if (active&&k.isAlive()) {
            for (int i = 0; i < twice; i++) {
                e.setBlock(e.getBlock() - 2);
                attack(k, e);
                e.setBlock(e.getBlock() + 2);
            }
            super.activate(k, e);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=2;
            desc = "Bypass 2 block and \n" +
                    "deal "+damage+" to enemy";
        }
    }

    @Override
    public void upgrade() {

    }
}
