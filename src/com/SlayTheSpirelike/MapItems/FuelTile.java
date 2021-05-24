package com.SlayTheSpirelike.MapItems;

import com.SlayTheSpirelike.Kapal;

public class FuelTile extends MapTile{

    private Kapal player;

    public FuelTile(Kapal player) {
        this.player = player;
    }

    @Override
    public void enterTile() {
        player.setFuel(player.getMaxfuel());
    }
}
