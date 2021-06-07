package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class Sprite extends JLabel implements Serializable {
    protected String image;
    protected int x,y, width, height;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageLoader.LoadImage(image),0,0,width,height,null);
    }

    public Sprite(String image) {
        this.image = image;
    }

    public void setDimension(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
