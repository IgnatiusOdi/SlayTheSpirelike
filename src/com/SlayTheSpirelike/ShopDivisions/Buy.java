package com.SlayTheSpirelike.ShopDivisions;

import com.SlayTheSpirelike.*;
import com.SlayTheSpirelike.Cards.*;
import com.SlayTheSpirelike.Relics.CauldronRelic;
import com.SlayTheSpirelike.Relics.CookieRelic;
import com.SlayTheSpirelike.Relics.MembershipCardRelic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Buy extends JPanel implements Serializable {

    private Body body;
    private Shop shop;
    private Kapal kapal;

    //IMAGE
    private final String hangingsign ="resources/hangingsign.png";
    private final String wood = "resources/woodtextures.jpg";
    private final String woodbg = "resources/woodbg.jpg";
    private final String coinimg = "resources/coin.png";

    //PROPERTIES
    private JLabel bg;
    private JLabel title;
    private JLabel coinsymbol;
    private JLabel coinplayer;
    private JLabel back;
    //SLOT 1
    private JLabel slot1;
    private Card card1;
    private JButton slot1button;
    private Boolean slot1bought;
    private JLabel slot1layer;
    private int slot1price;
    //SLOT 2
    private JLabel slot2;
    private Card card2;
    private JButton slot2button;
    private Boolean slot2bought;
    private JLabel slot2layer;
    private int slot2price;
    //SLOT 3
    private JLabel slot3;
    private Card card3;
    private JButton slot3button;
    private Boolean slot3bought;
    private JLabel slot3layer;
    private int slot3price;
    //SLOT 4
    private JLabel slot4;
    private Card card4;
    private JButton slot4button;
    private Boolean slot4bought;
    private JLabel slot4layer;
    private int slot4price;
    //SLOT 5
    private JLabel slot5;
    private Card card5;
    private JButton slot5button;
    private Boolean slot5bought;
    private JLabel slot5layer;
    private int slot5price;
    //SLOT 6
    private JLabel slot6;
    private Card card6;
    private JButton slot6button;
    private Boolean slot6bought;
    private JLabel slot6layer;
    private int slot6price;
    //SLOT 7
    private JLabel slot7;
    private Relic relic7;
    private JButton slot7button;
    private Boolean slot7bought;
    private JLabel slot7layer;
    private int slot7price;
    //SLOT 8
    private JLabel slot8;
    private Relic relic8;
    private JButton slot8button;
    private Boolean slot8bought;
    private JLabel slot8layer;
    private int slot8price;
    //SLOT 9
    private JLabel slot9;
    private Potion potion9;
    private JButton slot9button;
    private Boolean slot9bought;
    private JLabel slot9layer;
    private int slot9price;

    public Buy(Body body, Shop shop, Kapal kapal) {
        this.body = body;
        this.shop = shop;
        this.kapal = kapal;

        randomizeBuy();
        init();
        initCheats();
    }

    public void reConstruct(Body body, Shop shop, Kapal kapal){
        this.body = body;
        this.shop = shop;
        this.kapal = kapal;
        init();
    }

    public void refresh() {
        coinplayer.setText(String.valueOf(kapal.getCoin()));
    }

    private void randomizeBuy(){
        if (kapal instanceof Tanker) {
            int random1 = (int) (Math.random() * 12);
            int random2 = (int) (Math.random() * 12);
            int random3 = (int) (Math.random() * 12);
            int random4 = (int) (Math.random() * 12);
            int random5 = (int) (Math.random() * 12);
            int random6 = (int) (Math.random() * 12);
            int random8 = (int) (Math.random() * 3);
            int random9 = (int) (Math.random() * 3);
            card1 = tankerCards(random1);
            card2 = tankerCards(random2);
            card3 = tankerCards(random3);
            card4 = tankerCards(random4);
            card5 = tankerCards(random5);
            card6 = tankerCards(random6);
            relic8 = relicRandomizer(random8);
            potion9 = potionRandomizer(random9);
        } else if (kapal instanceof Warship) {
            int random1 = (int) (Math.random() * 14);
            int random2 = (int) (Math.random() * 14);
            int random3 = (int) (Math.random() * 14);
            int random4 = (int) (Math.random() * 14);
            int random5 = (int) (Math.random() * 14);
            int random6 = (int) (Math.random() * 14);
            int random8 = (int) (Math.random() * 3);
            int random9 = (int) (Math.random() * 3);
            card1 = warshipCards(random1);
            card2 = warshipCards(random2);
            card3 = warshipCards(random3);
            card4 = warshipCards(random4);
            card5 = warshipCards(random5);
            card6 = warshipCards(random6);
            relic8 = relicRandomizer(random8);
            potion9 = potionRandomizer(random9);
        } else {
            int random1 = (int) (Math.random() * 11);
            int random2 = (int) (Math.random() * 11);
            int random3 = (int) (Math.random() * 11);
            int random4 = (int) (Math.random() * 11);
            int random5 = (int) (Math.random() * 11);
            int random6 = (int) (Math.random() * 11);
            int random8 = (int) (Math.random() * 3);
            int random9 = (int) (Math.random() * 3);
            card1 = aircraftCards(random1);
            card2 = aircraftCards(random2);
            card3 = aircraftCards(random3);
            card4 = aircraftCards(random4);
            card5 = aircraftCards(random5);
            card6 = aircraftCards(random6);
            relic8 = relicRandomizer(random8);
            potion9 = potionRandomizer(random9);
        }
        relic7 = new MembershipCardRelic();
    }

    private void init() {
        setLayout(null);
        setSize(1162,648);
        setVisible(true);

        //INIT
        title = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(ImageLoader.LoadImage(hangingsign),0,0, this.getWidth(), this.getHeight(),null);
                g.setColor(Color.green);
                g.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 75));
                g.drawString("BUY",120,138);
                super.paintComponent(g);
            }
        };
        bg = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(ImageLoader.LoadImage(woodbg),0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        coinsymbol = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(ImageLoader.LoadImage(coinimg),0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        coinplayer = new JLabel(String.valueOf(kapal.getCoin()));
        back = new JLabel("<< BACK"){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(ImageLoader.LoadImage(wood),0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };

        //SLOT 1
        slot1 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                switch (card1.getType()) {
                    case "Self" -> g.setColor(Color.BLUE);
                    case "Enemy" -> g.setColor(Color.GREEN);
                    case "Battle" -> g.setColor(Color.MAGENTA);
                }
                g.fillRect(0,0, this.getWidth(), this.getHeight());
                g.setColor(Color.BLACK);
                g.setFont(new Font("Monospace", Font.BOLD, 15));
                g.drawString(card1.getNama(),10, this.getHeight()/4);
                g.drawImage(Assets.energy,0,0,20,20,null);
                g.drawString(String.valueOf(card1.getCost()),22,15);

                String[] descSplit = card1.getDesc().split("\n");
                for (int i = 0; i < descSplit.length; i++) {
                    g.drawString(descSplit[i],10,this.getHeight()/2 + ( i*30));
                }
                super.paintComponent(g);
            }
        };
        slot1bought = false;
        slot1layer = new JLabel("ALREADY BOUGHT");
        slot1price = 100;
        slot1button = new JButton(String.valueOf(slot1price));

        //SLOT 2
        slot2 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                switch (card2.getType()) {
                    case "Self" -> g.setColor(Color.BLUE);
                    case "Enemy" -> g.setColor(Color.GREEN);
                    case "Battle" -> g.setColor(Color.MAGENTA);
                }
                g.fillRect(0,0, this.getWidth(), this.getHeight());
                g.setColor(Color.BLACK);
                g.setFont(new Font("Monospace", Font.BOLD, 15));
                g.drawString(card2.getNama(),10,this.getHeight()/4);
                g.drawImage(Assets.energy,0,0,20,20,null);
                g.drawString(String.valueOf(card2.getCost()),22,15);

                String[] descSplit = card2.getDesc().split("\n");
                for (int i = 0; i < descSplit.length; i++) {
                    g.drawString(descSplit[i],10,this.getHeight()/2 + (i*30));
                }
                super.paintComponent(g);
            }
        };
        slot2bought = false;
        slot2layer = new JLabel("ALREADY BOUGHT");
        slot2price = 100;
        slot2button = new JButton(String.valueOf(slot2price));

        //SLOT 3
        slot3 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                switch (card3.getType()) {
                    case "Self" -> g.setColor(Color.BLUE);
                    case "Enemy" -> g.setColor(Color.GREEN);
                    case "Battle" -> g.setColor(Color.MAGENTA);
                }
                g.fillRect(0,0, this.getWidth(), this.getHeight());
                g.setColor(Color.BLACK);
                g.setFont(new Font("Monospace", Font.BOLD, 15));
                g.drawString(card3.getNama(),10,this.getHeight()/4);
                g.drawImage(Assets.energy,0,0,20,20,null);
                g.drawString(String.valueOf(card3.getCost()),22,15);

                String[] descSplit = card3.getDesc().split("\n");
                for (int i = 0; i < descSplit.length; i++) {
                    g.drawString(descSplit[i],10,this.getHeight()/2 + (i*30));
                }
                super.paintComponent(g);
            }
        };
        slot3bought = false;
        slot3layer = new JLabel("ALREADY BOUGHT");
        slot3price = 100;
        slot3button = new JButton(String.valueOf(slot3price));

        //SLOT 4
        slot4 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                switch (card4.getType()) {
                    case "Self" -> g.setColor(Color.BLUE);
                    case "Enemy" -> g.setColor(Color.GREEN);
                    case "Battle" -> g.setColor(Color.MAGENTA);
                }
                g.fillRect(0,0, this.getWidth(), this.getHeight());
                g.setColor(Color.BLACK);
                g.setFont(new Font("Monospace", Font.BOLD, 15));
                g.drawString(card4.getNama(),10,this.getHeight()/4);
                g.drawImage(Assets.energy,0,0,20,20,null);
                g.drawString(String.valueOf(card4.getCost()),22,15);

                String[] descSplit = card4.getDesc().split("\n");
                for (int i = 0; i < descSplit.length; i++) {
                    g.drawString(descSplit[i],10,this.getHeight()/2 + (i*30));
                }
                super.paintComponent(g);
            }
        };
        slot4bought = false;
        slot4layer = new JLabel("ALREADY BOUGHT");
        slot4price = 100;
        slot4button = new JButton(String.valueOf(slot4price));

        //SLOT 5
        slot5 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                switch (card5.getType()) {
                    case "Self" -> g.setColor(Color.BLUE);
                    case "Enemy" -> g.setColor(Color.GREEN);
                    case "Battle" -> g.setColor(Color.MAGENTA);
                }
                g.fillRect(0,0, this.getWidth(), this.getHeight());
                g.setColor(Color.BLACK);
                g.setFont(new Font("Monospace", Font.BOLD, 15));
                g.drawString(card5.getNama(),10,this.getHeight()/4);
                g.drawImage(Assets.energy,0,0,20,20,null);
                g.drawString(String.valueOf(card5.getCost()),22,15);

                String[] descSplit = card5.getDesc().split("\n");
                for (int i = 0; i < descSplit.length; i++) {
                    g.drawString(descSplit[i],10,this.getHeight()/2 + (i*30));
                }
                super.paintComponent(g);
            }
        };
        slot5bought = false;
        slot5layer = new JLabel("ALREADY BOUGHT");
        slot5price = 100;
        slot5button = new JButton(String.valueOf(slot5price));

        //SLOT 6
        slot6 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                switch (card6.getType()) {
                    case "Self" -> g.setColor(Color.BLUE);
                    case "Enemy" -> g.setColor(Color.GREEN);
                    case "Battle" -> g.setColor(Color.MAGENTA);
                }
                g.fillRect(0,0, this.getWidth(), this.getHeight());
                g.setColor(Color.BLACK);
                g.setFont(new Font("Monospace", Font.BOLD, 15));
                g.drawString(card6.getNama(),10,this.getHeight()/4);
                g.drawImage(Assets.energy,0,0,20,20,null);
                g.drawString(String.valueOf(card6.getCost()),22,15);

                String[] descSplit = card6.getDesc().split("\n");
                for (int i = 0; i < descSplit.length; i++) {
                    g.drawString(descSplit[i],10,this.getHeight()/2 + (i*30));
                }
                super.paintComponent(g);
            }
        };
        slot6bought = false;
        slot6layer = new JLabel("ALREADY BOUGHT");
        slot6price = 100;
        slot6button = new JButton(String.valueOf(slot6price));

        //SLOT 8
        slot8 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                switch (relic8.getRarity()) {
                    case "Common" -> g.setColor(Color.gray);
                    case "Uncommon" -> g.setColor(Color.green);
                    case "Rare" -> g.setColor(Color.orange);
                    case "Shop" -> g.setColor(Color.blue);
                }
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.drawImage(ImageLoader.LoadImage(relic8.getImage()),0,0, this.getWidth(), this.getHeight(),null);
                g.setColor(Color.black);
                g.setFont(new Font("Monospace", Font.BOLD, 15));
                g.drawString(relic8.getNama(), 10,this.getHeight()/4);

                String[] descSplit = relic8.getDesc().split("\n");
                for (int i = 0; i < descSplit.length; i++) {
                    g.drawString(descSplit[i],10,this.getHeight()/2 + (i*30));
                }
                super.paintComponent(g);
            }
        };
        slot8bought = false;
        slot8layer = new JLabel("ALREADY HAD");
        for (int i = 0; i < kapal.getRelic().size(); i++) {
            if (kapal.getRelic().get(i).getNama().equals(relic8.getNama())) {
                slot8bought = true;
                slot8layer.setVisible(true);
                break;
            }
        }
        if (relic8.getRarity().equals("Shop")) {
            slot8price = 300;
        } else if (relic8.getRarity().equals("Common")) {
            slot8price = 150;
        } else if (relic8.getRarity().equals("Uncommon")) {
            slot8price = 300;
        } else if (relic8.getRarity().equals("Rare")) {
            slot8price = 600;
        }
        slot8button = new JButton(String.valueOf(slot8price));

        //SLOT 9
        slot9 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                switch (potion9.getRarity()) {
                    case "Common" -> g.setColor(Color.gray);
                    case "Uncommon" -> g.setColor(Color.green);
                    case "Rare" -> g.setColor(Color.orange);
                }
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.drawImage(ImageLoader.LoadImage(potion9.getImage()),0,0, this.getWidth(), this.getHeight(),null);
                g.setColor(Color.black);
                g.setFont(new Font("Monospace", Font.BOLD, 15));
                g.drawString(potion9.getNama(), 10,this.getHeight()/4);

                String[] descSplit = potion9.getDesc().split("\n");
                for (int i = 0; i < descSplit.length; i++) {
                    g.drawString(descSplit[i],10,this.getHeight()/2 + (i*30));
                }
                super.paintComponent(g);
            }
        };
        slot9bought = false;
        slot9layer = new JLabel("ALREADY BOUGHT");
        if (potion9.getRarity().equals("Common")) {
            slot9price = 100;
        } else if (potion9.getRarity().equals("Uncommon")) {
            slot9price = 200;
        } else if (potion9.getRarity().equals("Rare")) {
            slot9price = 300;
        }
        slot9button = new JButton(String.valueOf(slot9price));

        //SLOT 7
        slot7 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Color.blue);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.drawImage(ImageLoader.LoadImage(relic7.getImage()),0,0, this.getWidth(), this.getHeight(),null);
                g.setColor(Color.black);
                g.setFont(new Font("Monospace", Font.BOLD, 15));
                g.drawString(relic7.getNama(), 10,this.getHeight()/4);

                String[] descSplit = relic7.getDesc().split("\n");
                for (int i = 0; i < descSplit.length; i++) {
                    g.drawString(descSplit[i],10,this.getHeight()/2 + (i*30));
                }
                super.paintComponent(g);
            }
        };
        slot7bought = false;
        slot7layer = new JLabel("ALREADY HAD");
        slot7price = 300;
        slot7button = new JButton(String.valueOf(slot7price));
        for (int i = 0; i < kapal.getRelic().size(); i++) {
            if (kapal.getRelic().get(i).getNama().equals(relic7.getNama())) {
                slot7bought = true;
                slot7layer.setVisible(true);

                slot1price /= 2;
                slot2price /= 2;
                slot3price /= 2;
                slot4price /= 2;
                slot5price /= 2;
                slot6price /= 2;
                slot8price /= 2;
                slot9price /= 2;
                slot1button.setText(String.valueOf(slot1price));
                slot2button.setText(String.valueOf(slot2price));
                slot3button.setText(String.valueOf(slot3price));
                slot4button.setText(String.valueOf(slot4price));
                slot5button.setText(String.valueOf(slot5price));
                slot6button.setText(String.valueOf(slot6price));
                slot8button.setText(String.valueOf(slot8price));
                slot9button.setText(String.valueOf(slot9price));
                break;
            }
        }

        //---------------------------------------------------------------------------------------------//

        //SIZE
        final int width = 200;
        final int height = 220;
        final int space = 25;

        //TITLE
        title.setBounds(this.getWidth()/2 - width,0, width*2, height - 60);
        add(title);

        //COIN SYMBOL
        coinsymbol.setBounds(870,60,50,50);
        add(coinsymbol);

        //COIN PLAYER
        coinplayer.setBounds(930,60,150,50);
        coinplayer.setFont(new Font("Monospace",Font.BOLD,30));
        coinplayer.setForeground(Color.white);
        add(coinplayer);

        //BACK
        back.setBounds(120,60,160,60);
        back.setForeground(Color.white);
        back.setFont(new Font("Monospace", Font.BOLD,30));
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.setVerticalAlignment(SwingConstants.CENTER);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                back.setLocation(back.getX() - 3, back.getY() + 3);
                back.setForeground(Color.white);

                body.setPanel(shop);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                back.setBorder(BorderFactory.createLineBorder(Color.red,1));
                back.setLocation(back.getX() + 3, back.getY() - 3);
                back.setForeground(Color.red);
                back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                back.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                back.setLocation(back.getX() - 3, back.getY() + 3);
                back.setForeground(Color.white);
            }
        });
        add(back);

        //SLOT 1 LAYER
        slot1layer.setBounds(space, height - space*2, width, height);
        slot1layer.setBackground(new Color(0,0,0, 240));
        slot1layer.setOpaque(true);
        slot1layer.setForeground(Color.red);
        slot1layer.setFont(new Font("Monospace", Font.ITALIC, 16));
        slot1layer.setHorizontalAlignment(SwingConstants.CENTER);
        slot1layer.setVisible(false);
        add(slot1layer);

        //SLOT 2 LAYER
        slot2layer.setBounds(width/2 + space, (height - space*2) + (height + space), width, height);
        slot2layer.setBackground(new Color(0,0,0, 240));
        slot2layer.setOpaque(true);
        slot2layer.setForeground(Color.red);
        slot2layer.setFont(new Font("Monospace", Font.ITALIC, 16));
        slot2layer.setHorizontalAlignment(SwingConstants.CENTER);
        slot2layer.setVisible(false);
        add(slot2layer);

        //SLOT 3 LAYER
        slot3layer.setBounds((width + space) + space, height - space*2, width, height);
        slot3layer.setBackground(new Color(0,0,0, 240));
        slot3layer.setOpaque(true);
        slot3layer.setForeground(Color.red);
        slot3layer.setFont(new Font("Monospace", Font.ITALIC, 16));
        slot3layer.setHorizontalAlignment(SwingConstants.CENTER);
        slot3layer.setVisible(false);
        add(slot3layer);

        //SLOT 4 LAYER
        slot4layer.setBounds((width/2 + space) + (width + space), (height - space*2) + (height + space), width, height);
        slot4layer.setBackground(new Color(0,0,0, 240));
        slot4layer.setOpaque(true);
        slot4layer.setForeground(Color.red);
        slot4layer.setFont(new Font("Monospace", Font.ITALIC, 16));
        slot4layer.setHorizontalAlignment(SwingConstants.CENTER);
        slot4layer.setVisible(false);
        add(slot4layer);

        //SLOT 5 LAYER
        slot5layer.setBounds((width + space)*2 + space, height - space*2, width, height);
        slot5layer.setBackground(new Color(0,0,0, 240));
        slot5layer.setOpaque(true);
        slot5layer.setForeground(Color.red);
        slot5layer.setFont(new Font("Monospace", Font.ITALIC, 16));
        slot5layer.setHorizontalAlignment(SwingConstants.CENTER);
        slot5layer.setVisible(false);
        add(slot5layer);

        //SLOT 6 LAYER
        slot6layer.setBounds((width/2 + space) + (width + space)*2, (height - space*2) + (height + space), width, height);
        slot6layer.setBackground(new Color(0,0,0, 240));
        slot6layer.setOpaque(true);
        slot6layer.setForeground(Color.red);
        slot6layer.setFont(new Font("Monospace", Font.ITALIC, 16));
        slot6layer.setHorizontalAlignment(SwingConstants.CENTER);
        slot6layer.setVisible(false);
        add(slot6layer);

        //SLOT 7 LAYER
        slot7layer.setBounds((width + space)*3 + space, height - space*2, width, height);
        slot7layer.setBackground(new Color(0,0,0, 240));
        slot7layer.setOpaque(true);
        slot7layer.setForeground(Color.red);
        slot7layer.setFont(new Font("Monospace", Font.ITALIC, 16));
        slot7layer.setHorizontalAlignment(SwingConstants.CENTER);
        slot7layer.setVisible(false);
        add(slot7layer);

        //SLOT 8 LAYER
        slot8layer.setBounds((width/2 + space) + (width + space)*3, (height - space*2) + (height + space), width, height);
        slot8layer.setBackground(new Color(0,0,0, 240));
        slot8layer.setOpaque(true);
        slot8layer.setForeground(Color.red);
        slot8layer.setFont(new Font("Monospace", Font.ITALIC, 16));
        slot8layer.setHorizontalAlignment(SwingConstants.CENTER);
        slot8layer.setVisible(false);
        add(slot8layer);

        //SLOT 9 LAYER
        slot9layer.setBounds((width + space)*4 + space, height - space*2, width, height);
        slot9layer.setBackground(new Color(0,0,0, 240));
        slot9layer.setOpaque(true);
        slot9layer.setForeground(Color.red);
        slot9layer.setFont(new Font("Monospace", Font.ITALIC, 16));
        slot9layer.setHorizontalAlignment(SwingConstants.CENTER);
        slot9layer.setVisible(false);
        add(slot9layer);

        //SLOT 1 BUTTON
        slot1button.setBorderPainted(false);
        slot1button.setBounds(space, (height - space*2) + height - 50, width, 50);
        slot1button.setHorizontalAlignment(SwingConstants.CENTER);
        slot1button.setFont(new Font("Monospace", Font.BOLD,20));
        slot1button.setForeground(Color.black);
        slot1button.setBackground(new Color(211, 211, 211));
        slot1button.setVisible(false);
        slot1button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (kapal.getCoin() >= slot1price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"CARD BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        slot1.setEnabled(false);
                        slot1bought = true;
                        slot1layer.setVisible(true);
                        kapal.setCoin(kapal.getCoin() - slot1price);
                        kapal.addCard(card1);
                        refresh();
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                slot1button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot1button.setVisible(false);
            }
        });
        add(slot1button);

        //SLOT 2 BUTTON
        slot2button.setBorderPainted(false);
        slot2button.setBounds(width/2 + space, (height - space*2) + (height + space) + height - 50, width, 50);
        slot2button.setHorizontalAlignment(SwingConstants.CENTER);
        slot2button.setFont(new Font("Monospace", Font.BOLD,20));
        slot2button.setForeground(Color.black);
        slot2button.setBackground(new Color(211, 211, 211));
        slot2button.setVisible(false);
        slot2button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (kapal.getCoin() >= slot2price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"CARD BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        slot2.setEnabled(false);
                        slot2bought = true;
                        slot2layer.setVisible(true);
                        kapal.setCoin(kapal.getCoin() - slot2price);
                        kapal.addCard(card2);
                        refresh();
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                slot2button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot2button.setVisible(false);
            }
        });
        add(slot2button);

        //SLOT 3 BUTTON
        slot3button.setBorderPainted(false);
        slot3button.setBounds((width + space) + space, (height - space*2) + height - 50, width, 50);
        slot3button.setHorizontalAlignment(SwingConstants.CENTER);
        slot3button.setFont(new Font("Monospace", Font.BOLD,20));
        slot3button.setForeground(Color.black);
        slot3button.setBackground(new Color(211, 211, 211));
        slot3button.setVisible(false);
        slot3button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (kapal.getCoin() >= slot3price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"CARD BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        slot3.setEnabled(false);
                        slot3bought = true;
                        slot3layer.setVisible(true);
                        kapal.setCoin(kapal.getCoin() - slot3price);
                        kapal.addCard(card3);
                        refresh();
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                slot3button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot3button.setVisible(false);
            }
        });
        add(slot3button);

        //SLOT 4 BUTTON
        slot4button.setBorderPainted(false);
        slot4button.setBounds((width/2 + space) + (width + space), (height - space*2) + (height + space) + height - 50, width, 50);
        slot4button.setHorizontalAlignment(SwingConstants.CENTER);
        slot4button.setFont(new Font("Monospace", Font.BOLD,20));
        slot4button.setForeground(Color.black);
        slot4button.setBackground(new Color(211, 211, 211));
        slot4button.setVisible(false);
        slot4button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (kapal.getCoin() >= slot4price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"CARD BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        slot4.setEnabled(false);
                        slot4bought = true;
                        slot4layer.setVisible(true);
                        kapal.setCoin(kapal.getCoin() - slot4price);
                        kapal.addCard(card4);
                        refresh();
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                slot4button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot4button.setVisible(false);
            }
        });
        add(slot4button);

        //SLOT 5 BUTTON
        slot5button.setBorderPainted(false);
        slot5button.setBounds((width + space)*2 + space, (height - space*2) + height - 50, width, 50);
        slot5button.setHorizontalAlignment(SwingConstants.CENTER);
        slot5button.setFont(new Font("Monospace", Font.BOLD,20));
        slot5button.setForeground(Color.black);
        slot5button.setBackground(new Color(211, 211, 211));
        slot5button.setVisible(false);
        slot5button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (kapal.getCoin() >= slot5price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"CARD BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        slot5.setEnabled(false);
                        slot5bought = true;
                        slot5layer.setVisible(true);
                        kapal.setCoin(kapal.getCoin() - slot5price);
                        kapal.addCard(card5);
                        refresh();
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                slot5button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot5button.setVisible(false);
            }
        });
        add(slot5button);

        //SLOT 6 BUTTON
        slot6button.setBorderPainted(false);
        slot6button.setBounds((width/2 + space) + (width + space)*2, (height - space*2) + (height + space) + height - 50, width, 50);
        slot6button.setHorizontalAlignment(SwingConstants.CENTER);
        slot6button.setFont(new Font("Monospace", Font.BOLD,20));
        slot6button.setForeground(Color.black);
        slot6button.setBackground(new Color(211, 211, 211));
        slot6button.setVisible(false);
        slot6button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (kapal.getCoin() >= slot6price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"CARD BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        slot6.setEnabled(false);
                        slot6bought = true;
                        slot6layer.setVisible(true);
                        kapal.setCoin(kapal.getCoin() - slot6price);
                        kapal.addCard(card6);
                        refresh();
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                slot6button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot6button.setVisible(false);
            }
        });
        add(slot6button);

        //SLOT 7 BUTTON
        slot7button.setBorderPainted(false);
        slot7button.setBounds((width + space)*3 + space, (height - space*2) + height - 50, width, 50);
        slot7button.setHorizontalAlignment(SwingConstants.CENTER);
        slot7button.setFont(new Font("Monospace", Font.BOLD,20));
        slot7button.setForeground(Color.black);
        slot7button.setBackground(new Color(211, 211, 211));
        slot7button.setVisible(false);
        slot7button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (kapal.getCoin() >= slot7price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"RELIC BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        slot7.setEnabled(false);
                        slot7bought = true;
                        slot7layer.setVisible(true);
                        kapal.setCoin(kapal.getCoin() - slot7price);
                        kapal.addRelic(relic7);
                        refresh();

                        slot1price /= 2;
                        slot2price /= 2;
                        slot3price /= 2;
                        slot4price /= 2;
                        slot5price /= 2;
                        slot6price /= 2;
                        slot8price /= 2;
                        slot9price /= 2;
                        slot1button.setText(String.valueOf(slot1price));
                        slot2button.setText(String.valueOf(slot2price));
                        slot3button.setText(String.valueOf(slot3price));
                        slot4button.setText(String.valueOf(slot4price));
                        slot5button.setText(String.valueOf(slot5price));
                        slot6button.setText(String.valueOf(slot6price));
                        slot8button.setText(String.valueOf(slot8price));
                        slot9button.setText(String.valueOf(slot9price));
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                slot7button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot7button.setVisible(false);
            }
        });
        add(slot7button);

        //SLOT 8 BUTTON
        slot8button.setBorderPainted(false);
        slot8button.setBounds((width/2 + space) + (width + space)*3, (height - space*2) + (height + space) + height - 50, width, 50);
        slot8button.setHorizontalAlignment(SwingConstants.CENTER);
        slot8button.setFont(new Font("Monospace", Font.BOLD,20));
        slot8button.setForeground(Color.black);
        slot8button.setBackground(new Color(211, 211, 211));
        slot8button.setVisible(false);
        slot8button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (kapal.getCoin() >= slot8price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"RELIC BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        slot8.setEnabled(false);
                        slot8bought = true;
                        slot8layer.setVisible(true);
                        kapal.setCoin(kapal.getCoin() - slot8price);
                        kapal.addRelic(relic8);
                        refresh();
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                slot8button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot8button.setVisible(false);
            }
        });
        add(slot8button);

        //SLOT 9 BUTTON
        slot9button.setBorderPainted(false);
        slot9button.setBounds((width + space)*4 + space, (height - space*2) + height - 50, width, 50);
        slot9button.setHorizontalAlignment(SwingConstants.CENTER);
        slot9button.setFont(new Font("Monospace", Font.BOLD,20));
        slot9button.setForeground(Color.black);
        slot9button.setBackground(new Color(211, 211, 211));
        slot9button.setVisible(false);
        slot9button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (kapal.getCoin() >= slot9price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"POTION BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        slot9.setEnabled(false);
                        slot9bought = true;
                        slot9layer.setVisible(true);
                        kapal.setCoin(kapal.getCoin() - slot9price);
                        kapal.addPotion(potion9);
                        refresh();
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                slot9button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot9button.setVisible(false);
            }
        });
        add(slot9button);

        //SLOT 1
        slot1.setBounds(space, height - space*2, width, height);
        slot1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!slot1bought) {
                    slot1button.setVisible(true);
                    slot1button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot1button.setVisible(false);
            }
        });
        add(slot1);

        //SLOT 2
        slot2.setBounds(width/2 + space, (height - space*2) + (height + space), width, height);
        slot2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!slot2bought) {
                    slot2button.setVisible(true);
                    slot2button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot2button.setVisible(false);
            }
        });
        add(slot2);

        //SLOT 3
        slot3.setBounds((width + space) + space, height - space*2, width, height);
        slot3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!slot3bought) {
                    slot3button.setVisible(true);
                    slot3button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot3button.setVisible(false);
            }
        });
        add(slot3);

        //SLOT 4
        slot4.setBounds((width/2 + space) + (width + space), (height - space*2) + (height + space), width, height);
        slot4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!slot4bought) {
                    slot4button.setVisible(true);
                    slot4button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot4button.setVisible(false);
            }
        });
        add(slot4);

        //SLOT 5
        slot5.setBounds((width + space)*2 + space, height - space*2, width, height);
        slot5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!slot5bought) {
                    slot5button.setVisible(true);
                    slot5button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot5button.setVisible(false);
            }
        });
        add(slot5);

        //SLOT 6
        slot6.setBounds((width/2 + space) + (width + space)*2, (height - space*2) + (height + space), width, height);
        slot6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!slot6bought) {
                    slot6button.setVisible(true);
                    slot6button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot6button.setVisible(false);
            }
        });
        add(slot6);

        //SLOT 7
        slot7.setBounds((width + space)*3 + space, height - space*2, width, height);
        slot7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!slot7bought) {
                    slot7button.setVisible(true);
                    slot7button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot7button.setVisible(false);
            }
        });
        add(slot7);

        //SLOT 8
        slot8.setBounds((width/2 + space) + (width + space)*3, (height - space*2) + (height + space), width, height);
        slot8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!slot8bought) {
                    slot8button.setVisible(true);
                    slot8button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot8button.setVisible(false);
            }
        });
        add(slot8);

        //SLOT 9
        slot9.setBounds((width + space)*4 + space, height - space*2, width, height);
        slot9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!slot9bought) {
                    slot9button.setVisible(true);
                    slot9button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                slot9button.setVisible(false);
            }
        });
        add(slot9);

        //BACKGROUND
        bg.setBounds(0, 0,1162,648);
        add(bg);
    }

    private void initCheats(){
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_E,0),"viewInven");
        getActionMap().put("viewInven",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Inventory:");
                System.out.println("Cards:");
                for (Card card : kapal.getCard()) {
                    System.out.println(card.getNama());
                }
                System.out.println("Potions:");
                for (Potion potion : kapal.getPotion()) {
                    System.out.println(potion.getNama());
                }
                System.out.println("Relics:");
                for (Relic relic : kapal.getRelic()) {
                    System.out.println(relic.getNama());
                }
            }
        });
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C,0),"infCoin");
        getActionMap().put("infCoin",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("inf coin");
                kapal.setCoin(9999999);
                coinplayer.setText(String.valueOf(kapal.getCoin()));
                repaint();revalidate();
            }
        });
    }

    private Card tankerCards(int random) {
        Card card;
        if (random == 0) {
            card = new HeavyArtileryCard();
        } else if (random == 1) {
            card = new OverclockingReactorCard();
        } else if (random == 2) {
            card = new FortifyCard();
        } else if (random == 3) {
            card = new RethinkCard();
        } else if (random == 4) {
            card = new OneforAllCard();
        } else if (random == 5) {
            card = new RerouteCard();
        } else if (random == 6) {
            card = new ExplodingPayloadCard();
        } else if (random == 7) {
            card = new MissleCard();
        } else if (random == 8) {
            card = new ExtraGunpowderCard();
        } else if (random == 9) {
            card = new SupportCannonCard();
        } else if (random == 10) {
            card = new HealCard();
        } else {
            random = (int) (Math.random() * 5);
            if (random == 0) {
                card = new AttackCard();
            } else if (random == 1) {
                card = new DefendCard();
            } else if (random == 2) {
                card = new GreedofPotCard();
            } else if (random == 3) {
                card = new RechargeCard();
            } else {
                card = new InspiringShotCard();
            }
        }

        return card;
    }

    private Card warshipCards(int random) {
        Card card;
        if (random == 0) {
            card = new SniperShotCard();
        } else if (random == 1) {
            card = new RocketSalvoCard();
        } else if (random == 2) {
            card = new CommandersWisdom();
        } else if (random == 3) {
            card = new RepositionCard();
        } else if (random == 4) {
            card = new LoadUpCard();
        } else if (random == 5) {
            card = new CounterplayCard();
        } else if (random == 6) {
            card = new GatlingGunCard();
        } else if (random == 7) {
            card = new DeflectCard();
        } else if (random == 8) {
            card = new PiercingShotCard();
        } else if (random == 9) {
            card = new StrategicShotCard();
        } else if (random == 10) {
            card = new FuelContainerCard();
        } else if (random == 11) {
            card = new SalvageCard();
        } else if (random == 12) {
            card = new TorpedoCard();
        } else {
            random = (int) (Math.random() * 5);
            if (random == 0) {
                card = new AttackCard();
            } else if (random == 1) {
                card = new DefendCard();
            } else if (random == 2) {
                card = new GreedofPotCard();
            } else if (random == 3) {
                card = new RechargeCard();
            } else {
                card = new InspiringShotCard();
            }
        }

        return card;
    }

    private Card aircraftCards(int random) {
        Card card;
        if (random == 0) {
            card = new HelicallCard();
        } else if (random == 1) {
            card = new SupportFlareCard();
        } else if (random == 2) {
            card = new DeniumShieldingCard();
        } else if (random == 3) {
            card = new MoralSupportCard();
        } else if (random == 4) {
            card = new AllOutAttackCard();
        } else if (random == 5) {
            card = new SupportFlareV2Card();
        } else if (random == 6) {
            card = new SelfRepairCard();
        } else if (random == 7) {
            card = new BufferCard();
        } else if (random == 8) {
            card = new CombustCard();
        } else if (random == 9) {
            card = new KamikazeCard();
        } else {
            random = (int) (Math.random() * 5);
            if (random == 0) {
                card = new AttackCard();
            } else if (random == 1) {
                card = new DefendCard();
            } else if (random == 2) {
                card = new GreedofPotCard();
            } else if (random == 3) {
                card = new RechargeCard();
            } else {
                card = new InspiringShotCard();
            }
        }

        return card;
    }

    private Relic relicRandomizer(int random) {
        Relic relic;
        if (random == 0) {
            relic = new CauldronRelic();
        } else if (random == 1) {
            relic = new CookieRelic();
        } else {
            random = (int) (Math.random() * 3);
            if (random == 0) {
                random = (int) (Math.random() * Statics.commonRelic.size());
                relic = Statics.commonRelic.get(random).copy();
            } else if (random == 1) {
                random = (int) (Math.random() * Statics.uncommonRelic.size());
                relic = Statics.uncommonRelic.get(random).copy();
            } else {
                random = (int) (Math.random() * Statics.rareRelic.size());
                relic = Statics.rareRelic.get(random).copy();
            }
        }

        return relic;
    }

    private Potion potionRandomizer(int random) {
        Potion potion;
        if (random == 0) {
            random = (int) (Math.random() * Statics.commonPotion.size());
            potion = Statics.commonPotion.get(random).copy();
        } else if (random == 1) {
            random = (int) (Math.random() * Statics.uncommonPotion.size());
            potion = Statics.uncommonPotion.get(random).copy();
        } else {
            random = (int) (Math.random() * Statics.rarePotion.size());
            potion = Statics.rarePotion.get(random).copy();
        }

        return potion;
    }

    public int getSlot1price() {
        return slot1price;
    }

    public void setSlot1price(int slot1price) {
        this.slot1price = slot1price;
    }

    public JLabel getSlot2() {
        return slot2;
    }

    public void setSlot2(JLabel slot2) {
        this.slot2 = slot2;
    }

    public Card getCard2() {
        return card2;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public JButton getSlot2button() {
        return slot2button;
    }

    public void setSlot2button(JButton slot2button) {
        this.slot2button = slot2button;
    }

    public Boolean getSlot2bought() {
        return slot2bought;
    }

    public void setSlot2bought(Boolean slot2bought) {
        this.slot2bought = slot2bought;
    }

    public JLabel getSlot2layer() {
        return slot2layer;
    }

    public void setSlot2layer(JLabel slot2layer) {
        this.slot2layer = slot2layer;
    }

    public int getSlot2price() {
        return slot2price;
    }

    public void setSlot2price(int slot2price) {
        this.slot2price = slot2price;
    }

    public JLabel getSlot3() {
        return slot3;
    }

    public void setSlot3(JLabel slot3) {
        this.slot3 = slot3;
    }

    public Card getCard3() {
        return card3;
    }

    public void setCard3(Card card3) {
        this.card3 = card3;
    }

    public JButton getSlot3button() {
        return slot3button;
    }

    public void setSlot3button(JButton slot3button) {
        this.slot3button = slot3button;
    }

    public Boolean getSlot3bought() {
        return slot3bought;
    }

    public void setSlot3bought(Boolean slot3bought) {
        this.slot3bought = slot3bought;
    }

    public JLabel getSlot3layer() {
        return slot3layer;
    }

    public void setSlot3layer(JLabel slot3layer) {
        this.slot3layer = slot3layer;
    }

    public int getSlot3price() {
        return slot3price;
    }

    public void setSlot3price(int slot3price) {
        this.slot3price = slot3price;
    }

    public JLabel getSlot4() {
        return slot4;
    }

    public void setSlot4(JLabel slot4) {
        this.slot4 = slot4;
    }

    public Card getCard4() {
        return card4;
    }

    public void setCard4(Card card4) {
        this.card4 = card4;
    }

    public JButton getSlot4button() {
        return slot4button;
    }

    public void setSlot4button(JButton slot4button) {
        this.slot4button = slot4button;
    }

    public Boolean getSlot4bought() {
        return slot4bought;
    }

    public void setSlot4bought(Boolean slot4bought) {
        this.slot4bought = slot4bought;
    }

    public JLabel getSlot4layer() {
        return slot4layer;
    }

    public void setSlot4layer(JLabel slot4layer) {
        this.slot4layer = slot4layer;
    }

    public int getSlot4price() {
        return slot4price;
    }

    public void setSlot4price(int slot4price) {
        this.slot4price = slot4price;
    }

    public JLabel getSlot5() {
        return slot5;
    }

    public void setSlot5(JLabel slot5) {
        this.slot5 = slot5;
    }

    public Card getCard5() {
        return card5;
    }

    public void setCard5(Card card5) {
        this.card5 = card5;
    }

    public JButton getSlot5button() {
        return slot5button;
    }

    public void setSlot5button(JButton slot5button) {
        this.slot5button = slot5button;
    }

    public Boolean getSlot5bought() {
        return slot5bought;
    }

    public void setSlot5bought(Boolean slot5bought) {
        this.slot5bought = slot5bought;
    }

    public JLabel getSlot5layer() {
        return slot5layer;
    }

    public void setSlot5layer(JLabel slot5layer) {
        this.slot5layer = slot5layer;
    }

    public int getSlot5price() {
        return slot5price;
    }

    public void setSlot5price(int slot5price) {
        this.slot5price = slot5price;
    }

    public JLabel getSlot6() {
        return slot6;
    }

    public void setSlot6(JLabel slot6) {
        this.slot6 = slot6;
    }

    public Card getCard6() {
        return card6;
    }

    public void setCard6(Card card6) {
        this.card6 = card6;
    }

    public JButton getSlot6button() {
        return slot6button;
    }

    public void setSlot6button(JButton slot6button) {
        this.slot6button = slot6button;
    }

    public Boolean getSlot6bought() {
        return slot6bought;
    }

    public void setSlot6bought(Boolean slot6bought) {
        this.slot6bought = slot6bought;
    }

    public JLabel getSlot6layer() {
        return slot6layer;
    }

    public void setSlot6layer(JLabel slot6layer) {
        this.slot6layer = slot6layer;
    }

    public int getSlot6price() {
        return slot6price;
    }

    public void setSlot6price(int slot6price) {
        this.slot6price = slot6price;
    }

    public JLabel getSlot7() {
        return slot7;
    }

    public void setSlot7(JLabel slot7) {
        this.slot7 = slot7;
    }

    public Relic getRelic7() {
        return relic7;
    }

    public void setRelic7(Relic relic7) {
        this.relic7 = relic7;
    }

    public JButton getSlot7button() {
        return slot7button;
    }

    public void setSlot7button(JButton slot7button) {
        this.slot7button = slot7button;
    }

    public Boolean getSlot7bought() {
        return slot7bought;
    }

    public void setSlot7bought(Boolean slot7bought) {
        this.slot7bought = slot7bought;
    }

    public JLabel getSlot7layer() {
        return slot7layer;
    }

    public void setSlot7layer(JLabel slot7layer) {
        this.slot7layer = slot7layer;
    }

    public int getSlot7price() {
        return slot7price;
    }

    public void setSlot7price(int slot7price) {
        this.slot7price = slot7price;
    }

    public JLabel getSlot8() {
        return slot8;
    }

    public void setSlot8(JLabel slot8) {
        this.slot8 = slot8;
    }

    public Relic getRelic8() {
        return relic8;
    }

    public void setRelic8(Relic relic8) {
        this.relic8 = relic8;
    }

    public JButton getSlot8button() {
        return slot8button;
    }

    public void setSlot8button(JButton slot8button) {
        this.slot8button = slot8button;
    }

    public Boolean getSlot8bought() {
        return slot8bought;
    }

    public void setSlot8bought(Boolean slot8bought) {
        this.slot8bought = slot8bought;
    }

    public JLabel getSlot8layer() {
        return slot8layer;
    }

    public void setSlot8layer(JLabel slot8layer) {
        this.slot8layer = slot8layer;
    }

    public int getSlot8price() {
        return slot8price;
    }

    public void setSlot8price(int slot8price) {
        this.slot8price = slot8price;
    }

    public JLabel getSlot9() {
        return slot9;
    }

    public void setSlot9(JLabel slot9) {
        this.slot9 = slot9;
    }

    public Potion getPotion9() {
        return potion9;
    }

    public void setPotion9(Potion potion9) {
        this.potion9 = potion9;
    }

    public JButton getSlot9button() {
        return slot9button;
    }

    public void setSlot9button(JButton slot9button) {
        this.slot9button = slot9button;
    }

    public Boolean getSlot9bought() {
        return slot9bought;
    }

    public void setSlot9bought(Boolean slot9bought) {
        this.slot9bought = slot9bought;
    }

    public JLabel getSlot9layer() {
        return slot9layer;
    }

    public void setSlot9layer(JLabel slot9layer) {
        this.slot9layer = slot9layer;
    }

    public int getSlot9price() {
        return slot9price;
    }

    public void setSlot9price(int slot9price) {
        this.slot9price = slot9price;
    }
}
