package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal.Kapal;

public class BlockPotion extends Potion {
    public BlockPotion() {
        super("Block Potion", "Self","Common");
    }

    @Override
    public void activate(Kapal kapal) {
        kapal.setBlock(kapal.getBlock()+10);
        active=false;
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.setBlock(kapal.getBlock()-10);
        if (kapal.getBlock()<0){
            kapal.setBlock(0);
        }
    }
}
