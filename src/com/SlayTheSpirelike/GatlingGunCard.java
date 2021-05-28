package com.SlayTheSpirelike;

public class GatlingGunCard extends Card{
    public GatlingGunCard() {
        super("Gatling Gun", "Enemy", 2);
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy) {
        if (active&& kapal.isAlive()) {
            for (int i = 0; i < twice; i++) {
                enemy.setBlock(enemy.getBlock() - 2);
                attack(kapal, enemy);
                enemy.setBlock(enemy.getBlock() + 2);
            }
            super.activate(kapal, enemy);
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
