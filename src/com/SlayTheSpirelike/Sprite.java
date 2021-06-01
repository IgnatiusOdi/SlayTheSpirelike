package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Sprite extends JLabel {
    protected BufferedImage image;
    protected int x,y, width, height;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,width,height,null);
    }

    public Sprite(BufferedImage image) {
        this.image = image;
    }

    public void setDimension(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

/*    protected JLabel item;
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
    }*/
}
