package com.SlayTheSpirelike.MapItems;

import com.SlayTheSpirelike.Body;
import com.SlayTheSpirelike.Kapal;

import javax.swing.*;

public class FuelTile extends MapTile{

    private Kapal player;

    public FuelTile(Kapal player) {
        this.player = player;
    }

    @Override
    public void enterTile() {
        player.setFuel(player.getMaxfuel());
    }

    @Override
    public void reInit(Body body, JPanel returnPanel, Kapal player) {
        this.player = player;
    }
}
