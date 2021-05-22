package com.SlayTheSpirelike;

import javax.swing.*;

public abstract class Sprite {
    protected JLabel item;
    protected JPanel panel;
    public Sprite(String image) {
        this.item = new JLabel();
        this.item.setIcon(new ImageIcon(image));
        this.panel = new JPanel();
        this.panel.add(item);
        //this.panel.setSize(50,50);
        this.panel.setOpaque(false);
    }

    public JLabel getItem() {
        return item;
    }

    public void setItem(JLabel item) {
        this.item = item;
    }

    public JPanel getPanel(int x, int y, int w, int h) {
        panel.setLocation(x,y);
        panel.setSize(w,h);
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
