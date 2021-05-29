package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Battle extends JPanel {
    private final Body body;
    private final JPanel returnPanel;
    private Kapal player;

    private JLabel  playerSprite, enemySprite,
                    energy,
                    potion1, potion2, potion3,
                    endTurn;
    private ArrayList<Relic> relics;
    private ArrayList<Card> hand;
    private int strengthtemp, strength;

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

    public Battle(Body body, JPanel returnPanel, Kapal player) {
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
        this.strengthtemp=0;
        this.strength=0;
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
                returnHand();
            }
        });
        add(endTurn);
    }

    //escape, no reward
    public void escape(){
        body.setPanel(returnPanel);
    }

    //draw x amount of cards
    public void draw(int amount){
        Random r = new Random();
        int cardIndex;
        for (int i = 0; i < amount; i++) {
            cardIndex = r.nextInt(player.getCard().size());
            hand.add(player.getCard(cardIndex));
            player.getCard().remove(cardIndex);
        }
    }

    //return all cards on hand to deck
    private void returnHand(){
        player.getCard().addAll(hand);
        hand.clear();
        reactivate();
    }

    //return 1 card from hand to deck
    private void returnHand(int index){
        player.getCard().add(hand.get(index));
        hand.remove(index);
        reactivate();
    }

    public void upgradeHand(){
        for (Card h:hand) {
            h.upgrade();
        }
    }
    public void downgradeHand(){
        for (Card h:hand) {
            h.downgrade();
        }
    }
    //turn active kembali jadi true
    public void reactivate(){
        player.reactivateCard();
    }

    public int getStrengthtemp() {
        return strengthtemp;
    }

    public void setStrengthtemp(int strengthtemp) {
        this.strengthtemp = strengthtemp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    //yang strength hanya satu turn
    public void removeStrengthtemp(){
        player.setAttack(player.getAttack()-strengthtemp);
        strengthtemp=0;
    }
    //yang strength untuk seluruh battle
    public void removeStrength(){
        player.setAttack(player.getAttack()-strength);
        strength=0;
    }
}
