package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.ShopDivisions.Buy;
import com.SlayTheSpirelike.Relic;

public class MembershipCardRelic extends Relic {
    public MembershipCardRelic() {
        super("Membership Card Relic", "Shop", "Special","resources/MembershipCard.png","Discount on all \n" +
                "product by 50%");
    }

    @Override
    public void activate(Buy buy){
        if(active){
            buy.setSlot1price(buy.getSlot1price()/2);
            buy.setSlot2price(buy.getSlot2price()/2);
            buy.setSlot3price(buy.getSlot3price()/2);
            buy.setSlot4price(buy.getSlot4price()/2);
            buy.setSlot5price(buy.getSlot5price()/2);
            buy.setSlot6price(buy.getSlot6price()/2);
            buy.setSlot7price(buy.getSlot7price()/2);
            buy.setSlot8price(buy.getSlot8price()/2);
            buy.setSlot9price(buy.getSlot9price()/2);
            active=false;
        }
    }

    @Override
    public void deactivate(Buy buy) {
        buy.setSlot1price(buy.getSlot1price()*2);
        buy.setSlot2price(buy.getSlot2price()*2);
        buy.setSlot3price(buy.getSlot3price()*2);
        buy.setSlot4price(buy.getSlot4price()*2);
        buy.setSlot5price(buy.getSlot5price()*2);
        buy.setSlot6price(buy.getSlot6price()*2);
        buy.setSlot7price(buy.getSlot7price()*2);
        buy.setSlot8price(buy.getSlot8price()*2);
        buy.setSlot9price(buy.getSlot9price()*2);
        active=true;
    }

    @Override
    public Relic copy() {
        return new MembershipCardRelic();
    }
}
