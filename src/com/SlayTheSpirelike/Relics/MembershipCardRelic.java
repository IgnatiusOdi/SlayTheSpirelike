package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Buy;
import com.SlayTheSpirelike.Relic;

public class MembershipCardRelic extends Relic {
    public MembershipCardRelic() {
        super("Membership Card Relic", "Shop", "Special","resources/MembershipCard.png","Discount on all \n" +
                "product by 50%");
    }

    @Override
    public void activate(Buy buy){
        if(active){
            buy.setCard1price(buy.getCard1price()/2);
            buy.setCard2price(buy.getCard2price()/2);
            buy.setCard3price(buy.getCard3price()/2);
            buy.setRelic1price(buy.getCard1price()/2);
            buy.setRelic2price(buy.getCard2price()/2);
            buy.setRelic3price(buy.getCard3price()/2);
            active=false;
        }
    }

    @Override
    public void deactivate(Buy buy) {
        buy.setCard1price(buy.getCard1price()*2);
        buy.setCard2price(buy.getCard2price()*2);
        buy.setCard3price(buy.getCard3price()*2);
        buy.setRelic1price(buy.getCard1price()*2);
        buy.setRelic2price(buy.getCard2price()*2);
        buy.setRelic3price(buy.getCard3price()*2);
        active=true;
    }
}
