package com.SlayTheSpirelike;

public class ForgePotion extends Potion{
    private boolean used;
    public ForgePotion() {
        super("Forge Potion", "Kapal", "Common", "resources/ForgePotion.png");
        used=true;
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active&&used){
            //method card upgrade
        }
    }

    @Override
    public void deactivate(Kapal kapal) {

    }
}
