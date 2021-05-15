package com.SlayTheSpirelike.notused;

import com.SlayTheSpirelike.Assets;

import java.awt.*;

public class CharSelect_old extends State {

    private Body_old body;

    public CharSelect_old(Body_old body) {
        this.body = body;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.mainMenuBackground_old,0,0,body.getWidht(),body.getHeight(),null);

    }

    @Override
    public void tick() {

    }
}
