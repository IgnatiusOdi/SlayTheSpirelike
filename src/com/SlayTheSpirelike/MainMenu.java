package com.SlayTheSpirelike;

import java.awt.*;

public class MainMenu extends State{

    private Body body;
    private Button newGame;

    public MainMenu(Body body) {
        this.body = body;
        this.newGame = new Button(body.getWidht()/2 -100, 100,200,50,body,1) {
            @Override
            public void render(Graphics g) {
                if (hovered) {
                    g.drawImage(Assets.plank1,this.x+10,this.y,this.widht,this.height,null);
                    g.setColor(Color.red);
                    g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
                    g.drawString("New Game",this.x+30+10,this.y+30);
                } else {
                    g.drawImage(Assets.plank1,this.x,this.y,this.widht,this.height,null);
                    g.setColor(Color.red);
                    g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
                    g.drawString("New Game",this.x+30,this.y+30);
                }
            }

            @Override
            public void tick() {
                if(body.getMouse().getX() >= x && body.getMouse().getX() <= (x + widht) && body.getMouse().getY() >= y && body.getMouse().getY() < (y + height))
                {
                    hovered = true;
                    pressed = body.getMouse().isPressed();
                    if(body.getMouse().isClicked())
                    {
                        //click event goes here


                        body.getMouse().setClicked(false);
                    }
                }
                else
                    hovered = false;
            }
        };


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.mainMenuBackground,0,0,body.getWidht(),body.getHeight(),null);

        g.setColor(Color.red);
//        g.setFont(new Font("Courier new", Font.BOLD, 30));
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",30));
        g.drawString("Main Menu", body.getWidht() / 2 - 80, 35);

        newGame.render(g);
    }

    @Override
    public void tick() {
        newGame.tick();
    }
}
