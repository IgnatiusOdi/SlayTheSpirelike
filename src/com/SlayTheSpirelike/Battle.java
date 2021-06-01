package com.SlayTheSpirelike;

import com.SlayTheSpirelike.Potions.InvinciblePotion;
import com.SlayTheSpirelike.Potions.RevivePotion;
import com.SlayTheSpirelike.Potions.SummonPotion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


public class Battle extends JPanel {
    private Random rnd;
    private final Body body;
    private final JPanel returnPanel;
    private Kapal player;

    private JLabel  playerSprite,
                    energy,
                    endTurn;
    private ArrayList<Potion> potions;
    private ArrayList<Relic> relics;
    private ArrayList<Card> hand;
    private Enemy enemy;
    private int strengthtemp, strength;
    private int potionchance;
    private boolean invincible, nopotion;

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

        g.drawImage(Assets.shield,350,420,50,50,null);
        g.drawString(String.valueOf(player.getBlock()),368,453);

        g.drawImage(Assets.deck, 10,580,40,55,null);
        g.setColor(Color.red);
        g.fillOval(40,620,25,25);
        g.setColor(Color.BLACK);
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",15));
        g.drawString(String.valueOf(player.getCard().size()),48,638);
    }

    public Battle(Body body, JPanel returnPanel, Kapal player) {
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
        this.strengthtemp=0;
        this.strength=0;
        this.potionchance = 100;
        this.invincible = false;
        this.nopotion = false;
        this.rnd = new Random();
        hand = new ArrayList<>(5);
        setSize(body.getWidth(), body.getHeight());
        setLayout(null);

        initComponents();


        //battle Begins

        initPlayer();
        draw(5);

    }

    private void initComponents(){
        final int   PLAYER_WIDTH = 300,
                    PLAYER_HEIGHT = 100;

        // TODO: 27/05/2021 clickevent
        potions = player.getPotion();
        for (int i = 0; i < potions.size(); i++) {
            potions.get(i).setDimension(400 + (i*30),15,25,25);
            potions.get(i).setBounds(400 + (i*30),15,25,25);
            potions.get(i).initForBattle(player,enemy,this);
            add(potions.get(i));
        }

        // TODO: 27/05/2021 Relic clickevent
        relics = player.getRelic();
        for (int i = 0; i < relics.size(); i++) {
            relics.get(i).setDimension(10 + (i*55),50,50,50);
            relics.get(i).setBounds(10 + (i*55),50,50,50);
            add(relics.get(i));
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
        energy.setBounds(70,320,100,50);
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
        endTurn.setBounds(1020,590,130,40);
        endTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                returnHand();
                draw(5);
                repaint();revalidate();invalidate();
            }
        });
        add(endTurn);
    }

    //escape, no reward
    public void escape(){
        body.setPanel(returnPanel);
    }

    // TODO: 31/05/2021 Enemy not redy
    private void initPlayer(){
        System.out.println(player.getCard().size());
        for (Card card : player.getCard()) {
            card.initForBattle(player,enemy,this);
        }
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

        //display card
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).setBounds(80 + (i * 185), 500, 180, 320);
            add(hand.get(i));
        }
    }

    //return all cards on hand to deck
    private void returnHand(){
        player.getCard().addAll(hand);
        for (Card card : hand) {
            remove(card);
        }
        hand.clear();
        reactivate();
        player.setEnergy(player.getMaxenergy());
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

    public int getPotionchance() {
        return potionchance;
    }

    public void setPotionchance(int potionchance) {
        this.potionchance = potionchance;
    }

    public void potionReward(){
        if (!nopotion){
            int p = rnd.nextInt(potionchance)+1;
            if (p<=20){
                int potion = rnd.nextInt(Statics.commonPotion.size());
                player.addPotion(Statics.commonPotion.get(potion));
            }
            else if(p<=30){
                int potion = rnd.nextInt(Statics.uncommonPotion.size());
                player.addPotion(Statics.uncommonPotion.get(potion));
            }
            else if(p<=35){
                int potion = rnd.nextInt(Statics.rarePotion.size());
                player.addPotion(Statics.rarePotion.get(potion));
            }
            else if(p<=40){
                if (player instanceof Aircraft){
                    player.addPotion(new SummonPotion());
                }
                else if (player instanceof Tanker){
                    player.addPotion(new InvinciblePotion());
                }
                if (player instanceof Warship){
                    player.addPotion(new RevivePotion());
                }
            }
        }
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }

    public boolean isNopotion() {
        return nopotion;
    }

    public void setNopotion(boolean nopotion) {
        this.nopotion = nopotion;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
