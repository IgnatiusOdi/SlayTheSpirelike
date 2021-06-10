package com.SlayTheSpirelike.MapItems;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Body;
import com.SlayTheSpirelike.Kapal;

import javax.swing.*;

public class EnemyTile extends MapTile{
    private Body body;
    private Kapal player;
    private JPanel returnPanel;
    private int stage;

    public EnemyTile(Body body, JPanel returnPanel, Kapal player, int stage) {
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
        this.stage = stage;
    }

    @Override
    public void enterTile() {
        body.setPanel(new Battle(body,returnPanel,player,stage));
    }

    @Override
    public void reInit(Body body, JPanel returnPanel, Kapal player) {
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
    }
}
