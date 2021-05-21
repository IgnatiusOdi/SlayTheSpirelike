package com.SlayTheSpirelike.MapItems;

import com.SlayTheSpirelike.Body;
import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Shop;

import javax.swing.*;

public class ShopTile extends MapTile{
    private Body body;
    private Shop shop;

    public ShopTile(Body body, JPanel returnPanel, Kapal player) {
//        shop = new Shop(body,returnPanel,player);
        this.body = body;
    }

    @Override
    public void enterTile() {
        body.setPanel(shop);
    }
}
