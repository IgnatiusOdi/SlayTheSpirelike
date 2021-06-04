package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Potion;

public class ForgePotion extends Potion {
    private boolean usedd;
    private boolean usedh;
    public ForgePotion() {
        super("Forge Potion", "Kapal", "Common", "resources/ForgePotion.png","Upgrade all cards \n" +
                "in your deck and hand for \n" +
                "the rest of battle");
        usedd=true;
        usedh=true;
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active&&usedd){
            kapal.upgradeCard();
            usedd=false;
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        kapal.downgradeCard();
    }

    @Override
    public void activate(Battle battle) {
        if(active&&usedh){
            battle.upgradeHand();
            usedh=false;
        }

    }

    @Override
    public void deactivate(Battle battle) {
        battle.downgradeHand();
    }

    @Override
    protected Potion copy() {
        return new ForgePotion();
    }
}
