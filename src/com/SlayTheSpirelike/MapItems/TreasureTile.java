package com.SlayTheSpirelike.MapItems;

import com.SlayTheSpirelike.Body;
import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Treasure;

import javax.swing.*;

public class TreasureTile extends MapTile{
    private Body body;
    private JPanel returnPanel;
    private Kapal player;

    public TreasureTile(Body body, JPanel returnPanel, Kapal player) {
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
    }

    @Override
    public void enterTile() {
        body.setPanel(new Treasure(body, player, returnPanel));
    }

    @Override
    public void reInit(Body body, JPanel returnPanel, Kapal player) {
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
    }
}
