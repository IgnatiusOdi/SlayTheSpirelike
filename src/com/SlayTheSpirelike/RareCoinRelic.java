package com.SlayTheSpirelike;

public class RareCoinRelic extends Relic{
    public RareCoinRelic() {
        super("Rare Coin Relic", "Uncommon", "Pick Up", "resources/rare_coin.png");
    }

    @Override
    public void activate(Kapal kapal) {
        if (kapal.isAlive()&&active){
            kapal.setCoin(kapal.getCoin()+5);
        }
    }
}
