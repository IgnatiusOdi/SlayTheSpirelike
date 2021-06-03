package com.SlayTheSpirelike;

import com.SlayTheSpirelike.Cards.TorpedoCard;
import com.SlayTheSpirelike.Potions.InvinciblePotion;
import com.SlayTheSpirelike.Potions.RevivePotion;
import com.SlayTheSpirelike.Potions.SummonPotion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


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
    private ArrayList<Card> singleuse;
    private Enemy enemy;
    private int strengthtemp, strength;
    private int potionchance;
    private int heal, energyplus; //untuk self repair //untuk Denium Shielding
    private boolean invincible, nopotion;
    private int bleed, bleeddmg;

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
        this.bleed = 0;
        this.bleeddmg = 1;
        this.energyplus = 0;
        this.rnd = new Random();
        hand = new ArrayList<>(5);
        singleuse = new ArrayList<>();
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

        // TODO: 01/06/2021 testing battle
        potions = player.getPotion();
        for (int i = 0; i < potions.size(); i++) {
            potions.get(i).setDimension(400 + (i*30),15,25,25);
            potions.get(i).setBounds(400 + (i*30),15,25,25);
            potions.get(i).initForBattle(player,enemy,this);
            add(potions.get(i));
        }

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

        initCheats();
    }

    private void initCheats(){
        Battle b = this;
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_I,0),"fillEnergy");
        getActionMap().put("fillEnergy",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Fill energy");
                player.setEnergy(9);
                repaint();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_K,0),"addCard");
        getActionMap().put("addCard",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner s = new Scanner(System.in);
                System.out.print("Card Num:");
                Card c = Statics.cards.get(s.nextInt()).copy();
                c.initForBattle(player,enemy,b);
                hand.add(c);
                displayCard();
                repaint();
            }
        });
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
        player.activateRelic("Start Battle",enemy,this);
    }

    private void deInitPlayer(){
        for (Card card : player.getCard()) {
            card.deInitBattle();
        }
        player.activateRelic("End Battle",enemy,this);
        player.deactivateRelic();
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
        displayCard();
    }

    public void drawTorpedo(int draw){
        for (int i = 0; i < draw; i++) {
            hand.add(new TorpedoCard());
        }
    }

    public void displayCard(){
        for (int i = 0; i < hand.size(); i++) {
            remove(hand.get(i));
            hand.get(i).setBounds(80 + (i * 185), 500, 180, 320);
            add(hand.get(i));
        }
    }

    //return all cards on hand to deck
    private void returnHand(){
        //for torpedo card
        for (Card card : hand) {
            if (card.isDispose()){
                hand.remove(card);
            }
        }
        player.getCard().addAll(hand);
        for (Card card : hand) {
            hand.remove(card);
        }
        hand.clear();
        player.getCard().addAll(singleuse);
        singleuse.clear();
        reactivate();
        player.setEnergy(player.getMaxenergy());
    }

    //return 1 card from hand to deck
    private void returnHand(int index){
        if(!hand.get(index).isDispose()){
            if(hand.get(index).isSingleuse()){
                singleuse.add(hand.get(index));
            }
            else{
                player.getCard().add(hand.get(index));
            }
        }
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

    //untuk heal after battle
    public void restoreHealth(){
        player.setHealth(player.getHealth()+heal);
        if (player.getHealth()> player.getMaxhealth()){
            player.setHealth(player.getMaxhealth());
        }
        heal=0;
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

    public void bleed(){
        if (bleed>0){
            enemy.setHealth(enemy.getHealth()-bleeddmg);
            bleed--;
        }
    }

    //untuk denium shielding
    public void energy(){
        player.setEnergy(player.getEnergy()+energyplus);
        energyplus=0;
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

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getEnergyplus() {
        return energyplus;
    }

    public void setEnergyplus(int energyplus) {
        this.energyplus = energyplus;
    }

    public int getBleed() {
        return bleed;
    }

    public void setBleed(int bleed) {
        this.bleed = bleed;
    }

    public int getBleeddmg() {
        return bleeddmg;
    }

    public void setBleeddmg(int bleeddmg) {
        this.bleeddmg = bleeddmg;
    }
}
