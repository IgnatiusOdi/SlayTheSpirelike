package com.SlayTheSpirelike;

public abstract class Button implements Drawable {
    protected int x,y,widht,height,id;
    protected boolean hovered,pressed;
    protected Body body;

    public Button(int x,int y,int widht,int height,Body body,int id) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.widht = widht;
        this.body = body;
        this.id = id;
    }

}
