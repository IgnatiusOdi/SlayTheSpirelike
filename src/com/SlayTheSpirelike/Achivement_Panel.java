package com.SlayTheSpirelike;

import javax.swing.*;

public class Achivement_Panel extends JPanel {
    private Body body ;

    public Achivement_Panel(Body body) {
        this.body = body;
        setLayout(null);
        setSize(body.getWidth(), body.getHeight());

    }
}
