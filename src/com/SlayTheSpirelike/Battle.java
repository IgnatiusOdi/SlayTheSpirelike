package com.SlayTheSpirelike;

import com.SlayTheSpirelike.Cards.TorpedoCard;
import com.SlayTheSpirelike.Enemies.EarthshakerEnemy;
import com.SlayTheSpirelike.Enemies.KingOfDestroyerEnemy;
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
    private JLabel playerSprite, endTurn;
    private Kapal player;
    private ArrayList<Potion> potions;
    private ArrayList<Potion> usedpotions;
    private ArrayList<Relic> relics;
    private ArrayList<Card> hand;
    private ArrayList<Card> singleuse;
    private Enemy enemy;
    private int strengthtemp, strength;
    private int potionchance;
    private int heal, energyplus; //untuk self repair //untuk Denium Shielding
    private boolean invincible, nopotion;
    private int bleed, bleeddmg;
    private int stage;
    private boolean boss;

    //override to draw image
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color bgGray = new Color(101, 101, 101, 191);

        if (stage==1) {
            g.drawImage(Assets.battle1BG,0,0,body.getWidth(),body.getHeight(),null);
        } else {
            g.drawImage(Assets.battle2BG,0,0,body.getWidth(),body.getHeight(),null);
        }
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));

        g.setColor(bgGray);
        g.fillRect(0,0,body.getWidth(),50);

        g.setColor(Color.BLACK);
        g.drawString(player.getNama(),10,35);

        g.drawImage(Assets.heart,200,18,25,25,null);
        g.drawString(player.getHealth() + "/" + player.getMaxhealth(),230,35);

        g.drawImage(Assets.coin,350,15,25,25,null);
        g.drawString(String.valueOf(player.getCoin()),380,35);

        g.setColor(bgGray);
        g.fillRect(70,320,100,50);
        g.drawImage(Assets.energy,70,320,50,50,null);
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",30));
        g.setColor(Color.yellow);
        g.drawString(String.valueOf(player.getEnergy()),130,360);

        g.drawImage(Assets.shield,350,420,50,50,null);
        g.setColor(Color.black);
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
        g.drawString(String.valueOf(player.getBlock()),368,453);

        g.setColor(bgGray);
        g.fillRect(700,350,100,25);
        g.drawImage(Assets.heart,700,350,25,25,null);
        g.setColor(Color.black);
        g.drawString(enemy.getHealth() + "/" + enemy.getMaxhealth(),730,370);

        g.drawImage(Assets.shield,650,420,50,50,null);
        g.drawString(String.valueOf(enemy.getBlock()),668,453);

        g.drawImage(Assets.deck, 10,580,40,55,null);
        g.setColor(Color.red);
        g.fillOval(40,620,25,25);
        g.setColor(Color.BLACK);
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",15));
        g.drawString(String.valueOf(player.getCard().size()),48,638);
    }

    //INIT BLOCK
    {
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
        usedpotions = new ArrayList<>();
    }

    public Battle(Body body, JPanel returnPanel, Kapal player,int stage) {
        this.boss = false;
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
        this.enemy = randEnemy();
        this.stage = stage;
        setSize(body.getWidth(), body.getHeight());
        setLayout(null);

        initComponents();


        // Battle Begins ////////////////////////////////////////////////////////

        initPlayer();
        draw(5);

    }

    //for boss, bossflag b1 = KD, b2 = EI
    public Battle(Body body, JPanel returnPanel, Kapal player,String bossFlag) {
        this.boss = true;
        this.body = body;
        this.returnPanel = returnPanel;
        this.player = player;
        if (bossFlag.equals("b1")) {
            this.stage = 1;
            this.enemy = new KingOfDestroyerEnemy();
        } else {
            this.enemy = new EarthshakerEnemy();
        }
        setSize(body.getWidth(), body.getHeight());
        setLayout(null);

        initComponents();

        // Battle Begins ////////////////////////////////////////////////////////

        initPlayer();
        draw(5);
    }

    private void initComponents(){
        final int   PLAYER_WIDTH = 300,
                    PLAYER_HEIGHT = 100;

        potions = player.getPotion();
        for (int i = 0; i < potions.size(); i++) {
            potions.get(i).setBounds(400 + (i*30),15,25,25);
            potions.get(i).initForBattle(player,enemy,this);
            add(potions.get(i));
        }

        relics = player.getRelic();
        for (int i = 0; i < relics.size(); i++) {
            relics.get(i).setBounds(10 + (i*55),50,50,50);
            relics.get(i).setPanel(this);
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

        enemy.setBounds(700,400,300,100);
        add(enemy);

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

        final Battle b = this;
        endTurn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                returnHand();
                player.activateRelic("End Turn",enemy,b);
                enemy.useSkill(player,enemy,b);
                draw(5);
                player.activateRelic("Start Turn",enemy,b);
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

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_I,0),"fillHealth");
        getActionMap().put("fillHealth",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Fill health");
                player.setHealth(100);
                repaint();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_K,0),"addCard");
        getActionMap().put("addCard",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner s = new Scanner(System.in);
                System.out.print("Card type:");
                int type = s.nextInt();
                System.out.print("Card Num:");
                Card c;
                if (type==0){
                    c = Statics.commonCards.get(s.nextInt()).copy();
                } else if (type==1){
                    c = Statics.tankerCards.get(s.nextInt()).copy();
                } else if (type==2){
                    c = Statics.warshipCards.get(s.nextInt()).copy();
                } else {
                    c = Statics.aircraftCards.get(s.nextInt()).copy();
                }
                c.initForBattle(player,enemy,b);
                hand.add(c);
                displayCard();
                repaint();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_R,0),"addRelic");
        getActionMap().put("addRelic",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner s = new Scanner(System.in);
                System.out.print("Relic type");
                int type = s.nextInt();
                System.out.print("Relic Num:");
                Relic r;
                if (type==1){
                    r = Statics.commonRelic.get(s.nextInt()).copy();
                } else if (type==2){
                    r = Statics.uncommonRelic.get(s.nextInt()).copy();
                } else if (type==3){
                    r = Statics.rareRelic.get(s.nextInt()).copy();
                } else if (type==4){
                    r = Statics.shopRelic.get(s.nextInt()).copy();
                } else {
                    r = Statics.bossRelic.get(s.nextInt()).copy();
                }
                r.activate(player,enemy,b);
                player.addRelic(r);
                repaint();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_L,0),"showCards");
        getActionMap().put("showCards",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Card :");
                for (Card card : player.getCard()) {
                    System.out.println(card.getNama());
                }
                System.out.println("Hand:");
                for (Card card : hand) {
                    System.out.println(card.getNama());
                }
            }
        });
    }

    private Enemy randEnemy(){
        int eType = rnd.nextInt(10);
        if (eType < 7){
            return Statics.commonEnemy.get(rnd.nextInt(Statics.commonEnemy.size())).copy();
        } else {
            return Statics.eliteEnemy.get(rnd.nextInt(Statics.eliteEnemy.size())).copy();
        }

    }

    //escape, no reward
    public void escape(){
        body.setPanel(returnPanel);
    }

    public void endBattle(String winner){
        returnHand();
        forceDisposePotions();
        deInitPlayer();

        removeAll();
        JLabel grayOut = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(101, 101, 101, 191));
                g.fillRect(0,0, body.getWidth(), body.getHeight());

                g.setColor(Color.yellow);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",50));
                if (winner.equals("p")){
                    g.drawString("You Win",body.getWidth()/2 - 100,body.getHeight()/2 - 25);
                } else if (winner.equals("e")) {
                    g.drawString("You Lose",body.getWidth()/2 - 100,body.getHeight()/2 - 25);
                }
            }
        };
        grayOut.setBounds(0,0, body.getWidth(), body.getHeight());

        //if player wins, send to map. if enemy wins, send to main menu
        //if boss, send to next map
        if (winner.equals("p")) {
            grayOut.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (boss) {
                        body.setPanel(new Map(body,player,stage++));
                    } else {
                        body.setPanel(returnPanel);
                    }
                }
            });
        } else if (winner.equals("e")){
            grayOut.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    body.setPanel(new MainMenu(body));
                }
            });
        }
        add(grayOut);

        repaint();
    }

    private void initPlayer(){
        System.out.println(player.getCard().size());
        for (Card card : player.getCard()) {
            card.initForBattle(player,enemy,this);
        }
        player.activateRelic("Start Battle",enemy,this);
        player.activateRelic("Start Turn",enemy,this);
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
            Card t = new TorpedoCard();
            t.initForBattle(player,enemy,this);
            hand.add(t);
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
//        hand.removeIf(Card::isDispose); conflicted, don't uncomment
        player.getCard().addAll(hand);
        for (Card card : hand) {
            remove(card);
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

    // make use potion implement

    // at start every turn
    public void activatePotions(){
        for(Potion p: usedpotions){
            p.activate(player,enemy,this);
        }
    }

    public void disposePotions(){
        for (int i = usedpotions.size()-1; i >= 0 ; i--) {
            if(!usedpotions.get(i).isActive()){
                usedpotions.get(i).deactivate(player,enemy,this);
                usedpotions.remove(i);
            }
        }
    }

    //when battle end
    public void forceDisposePotions(){
        for(Potion p: usedpotions){
            p.deactivate(player,enemy,this);
        }
        usedpotions.clear();
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
                player.addPotion(Statics.commonPotion.get(potion).copy());
            }
            else if(p<=30){
                int potion = rnd.nextInt(Statics.uncommonPotion.size());
                player.addPotion(Statics.uncommonPotion.get(potion).copy());
            }
            else if(p<=35){
                int potion = rnd.nextInt(Statics.rarePotion.size());
                player.addPotion(Statics.rarePotion.get(potion).copy());
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
