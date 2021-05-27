package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Battle extends JPanel {
    private final Body body;
    private Kapal player;

    private JLabel  playerSprite, enemySprite,
                    energy,
                    potion1, potion2, potion3,
                    endTurn;
    private ArrayList<Relic> relics;

    //override to draw image
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.battle1BG,0,0,body.getWidth(),body.getHeight(),null);
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));

        g.setColor(new Color(101, 101, 101, 191));
        g.fillRect(0,0,body.getWidth(),50);

        g.setColor(Color.BLACK);
        g.drawString(player.getNama(),10,35);

        g.drawImage(Assets.heart,200,18,25,25,null);
        g.drawString(player.getHealth() + "/" + player.getMaxhealth(),230,35);

        g.drawImage(Assets.coin,350,15,25,25,null);
        g.drawString(String.valueOf(player.getCoin()),380,35);
    }

    public Battle(Body body, Kapal player) {
        this.body = body;
        this.player = player;
        setSize(body.getWidth(), body.getHeight());
        setLayout(null);

        final int   PLAYER_WIDTH = 300,
                    PLAYER_HEIGHT = 100;

        // TODO: 27/05/2021 potion is null, cannot access
//        potion1 = player.getPotion(0).getItem();
//        potion1.setBounds(400,15,25,25);
//        add(potion1);

        // TODO: 27/05/2021 Relic is empty
        relics = player.getRelic();
        JLabel[] relicLabel = new JLabel[relics.size()];
        for (int i = 0; i < relics.size(); i++) {
            relicLabel[i] = relics.get(i).getItem();
            relicLabel[i].setBounds(10+(25*i),30,25,25);
            add(relicLabel[i]);
        }

        //extend class jlabel untuk override paintComponent
        playerSprite = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (player instanceof Tanker){
                    g.drawImage(Assets.tanker, 0, 0,PLAYER_WIDTH,PLAYER_HEIGHT,null);
                } else if (player instanceof Warship){
                    g.drawImage(Assets.warship, 0, 0,PLAYER_WIDTH,PLAYER_HEIGHT,null);
                } else if (player instanceof Aircraft){
                    g.drawImage(Assets.carrier, 0, 0,PLAYER_WIDTH,PLAYER_HEIGHT,null);
                }
            }
        };
        playerSprite.setBounds(30,400,PLAYER_WIDTH,PLAYER_HEIGHT);
        add(playerSprite);

        energy = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(101, 101, 101, 191));
                g.fillRect(0,0,100,50);
                g.drawImage(Assets.energy,0,0,50,50,null);

                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",30));
                g.setColor(Color.yellow);
                g.drawString(String.valueOf(player.getEnergy()),60,40);
            }
        };
        energy.setBounds(70,520,100,50);
        add(energy);

        endTurn = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Assets.plank1,0,0,130,40,null);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
                g.drawString("End Turn",10,28);
            }
        };
        endTurn.setBounds(900,500,130,40);
        endTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // TODO: 27/05/2021 clickEvent
            }
        });
        add(endTurn);
    }

}
