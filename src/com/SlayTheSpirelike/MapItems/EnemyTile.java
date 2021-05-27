package com.SlayTheSpirelike.MapItems;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Body;
import com.SlayTheSpirelike.Kapal;

import javax.swing.*;

public class EnemyTile extends MapTile{
    private Body body;
    private Kapal player;
    private JPanel returnPanel;

    public EnemyTile(Body body, JPanel returnPanel, Kapal player) {
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
    }

    @Override
    public void enterTile() {
        body.setPanel(new Battle(body,player));
    }
}
