package com.SlayTheSpirelike.MapItems;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Body;
import com.SlayTheSpirelike.Kapal;

import javax.swing.*;

public class BossTile extends MapTile{
    private Body body;
    private Kapal player;
    private JPanel returnPanel;
    private String flags;

    public BossTile(Body body, JPanel returnPanel, Kapal player, int stage) {
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
        this.flags = (stage==1) ? "b1" : "b2";
    }

    @Override
    public void enterTile() {
        body.setPanel(new Battle(body,returnPanel,player,flags));
    }

    @Override
    public void reInit(Body body, JPanel returnPanel, Kapal player) {
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
    }
}
