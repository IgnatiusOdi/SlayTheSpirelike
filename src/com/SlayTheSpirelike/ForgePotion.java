package com.SlayTheSpirelike;

public class ForgePotion extends Potion{
    private boolean used;
    public ForgePotion() {
        super("Forge Potion", "Kapal", "Common", "resources/ForgePotion.png","Upgrade all cards \n" +
                "in your deck for \n" +
                "the rest of battle");
        used=true;
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active&&used){
            kapal.upgradeCard();
            used=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.downgradeCard();
    }
}
