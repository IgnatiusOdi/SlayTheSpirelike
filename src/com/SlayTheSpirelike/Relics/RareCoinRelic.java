package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class RareCoinRelic extends Relic {
    public RareCoinRelic() {
        super("Rare Coin Relic", "Uncommon", "Pick Up", "resources/rare_coin.png","Upon pick up, \n" +
                "gain 5 coins");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setCoin(kapal.getCoin()+5);
        }
    }
}
