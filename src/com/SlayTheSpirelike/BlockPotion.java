package com.SlayTheSpirelike;

public class BlockPotion extends Potion {
    public BlockPotion() {
        super("Block Potion", "Self","Common","resources/BlockPotion.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setBlock(kapal.getBlock()+10);
            active=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setBlock(kapal.getBlock()-10);
        if (kapal.getBlock()<0){
            kapal.setBlock(0);
        }
    }
}
