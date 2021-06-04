package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class BlockPotion extends Potion {
    public BlockPotion() {
        super("Block Potion", "Self","Common","resources/BlockPotion.png","Gain 10 block \n" +
                "(remove when next turn)");
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

    @Override
    public Potion copy() {
        return new BlockPotion();
    }
}
