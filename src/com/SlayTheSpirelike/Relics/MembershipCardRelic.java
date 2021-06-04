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

            active=false;
        }
    }

    @Override
    public void deactivate(Buy buy) {

        active=true;
    }
}
