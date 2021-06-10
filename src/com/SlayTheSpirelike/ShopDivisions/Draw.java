package com.SlayTheSpirelike.ShopDivisions;

import com.SlayTheSpirelike.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Draw extends JPanel {

    private Body body;
    private Shop shop;
    private Kapal kapal;

    //DRAW COUNTER
    int drawcounter = 0;

    //SIZE
    private final int width = 200;
    private final int height = 220;
    private final int space = 25;

    //IMAGE
    private final Image hangingsign = new ImageIcon("resources/hangingsign.png").getImage();
    private final Image wood = new ImageIcon("resources/woodtextures.jpg").getImage();
    private final Image woodbg = new ImageIcon("resources/woodbg.jpg").getImage();
    private final Image coinimg = new ImageIcon("resources/coin.png").getImage();

    //PROPERTIES
    private JLabel bg;
    private JLabel title;
    private JLabel draw;
    private JLabel card;
    private JLabel drawbutton;
    private JLabel percentagelist;
    private JLabel coinsymbol;
    private JLabel coinplayer;
    private JLabel back;

    public Draw(Body body, Shop shop, Kapal kapal) {
        this.body = body;
        this.shop = shop;
        this.kapal = kapal;
        init();
    }

    public void refresh() {
        coinplayer.setText(String.valueOf(kapal.getCoin()));
    }

    private void init() {
        setLayout(null);
        setSize(1162,648);
        setVisible(true);

        //INIT
        title = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(hangingsign, 0, 0, this.getWidth(), this.getHeight(),null);
                g.setColor(Color.blue);
                g.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 70));
                g.drawString("DRAW", 90, 138);
                super.paintComponent(g);
            }
        };
        bg = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(woodbg,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        card = new JLabel("?");
        draw = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        drawbutton = new JLabel(">> Click here to DRAW random (1x) <<"){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        percentagelist = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                g.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 20));
                g.setColor(Color.white);
                g.drawString("Zonk -> 70%", 20, 38);
                g.setColor(Color.magenta);
                g.drawString("Card -> 10% (Class Card)", 20, 105);
                g.setColor(Color.yellow);
                g.drawString("Potion -> 10% (90% Uncommon, 10% Rare)", 20, 175);
                g.setColor(Color.cyan);
                g.drawString("Relic -> 10% (90% Uncommon, 10% Rare)", 20, 245);
                super.paintComponent(g);
            }
        };
        coinsymbol = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(coinimg,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        coinplayer = new JLabel(String.valueOf(kapal.getCoin()));
        back = new JLabel("<< BACK") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(),this.getHeight(),null);
                super.paintComponent(g);
            }
        };

        //---------------------------------------------------------------------------------------//

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
                body.setPanel(shop);
                mouseExited(e);
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

        //CARD
        card.setBounds(space*3, height, this.getWidth()/2 - space*5, (int) (height * 1.6));
        card.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 50));
        card.setHorizontalAlignment(SwingConstants.CENTER);
        card.setForeground(Color.black);
        card.setBackground(new Color(255, 255, 255, 155));
        card.setOpaque(true);
        add(card);

        //DRAW
        draw.setBounds(space, height - 40, this.getWidth()/2 - space, height*2);
        add(draw);

        //DRAW BUTTON
        drawbutton.setBounds(this.getWidth()/2 + space, height - 40, this.getWidth()/2 - space*2, 50);
        drawbutton.setFont(new Font("Monospace", Font.BOLD,25));
        drawbutton.setHorizontalAlignment(SwingConstants.CENTER);
        drawbutton.setForeground(Color.green);
        drawbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Feeling lucky today? (250C)", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK COUNTER
                    if (drawcounter == 0) {
                        //CHECK MONEY
                        if (kapal.getCoin() >= 250) {
                            kapal.setCoin(kapal.getCoin() - 250);
                            coinplayer.setText(String.valueOf(kapal.getCoin()));
                            drawcounter++;
                            //DRAW
                            int random = (int) (Math.random() * 10);
                            if (random <= 9) {
                                //10% CARD
                                if (kapal instanceof Tanker) {
                                    random = (int) (Math.random() * Statics.tankerCards.size());
                                    Card randomcard = Statics.tankerCards.get(random).copy();
                                    kapal.addCard(randomcard);
                                    card = new JLabel() {
                                        @Override
                                        protected void paintComponent(Graphics g) {
                                            switch (randomcard.getType()) {
                                                case "Self" -> g.setColor(Color.BLUE);
                                                case "Enemy" -> g.setColor(Color.GREEN);
                                                case "Battle" -> g.setColor(Color.MAGENTA);
                                            }
                                            g.fillRect(0,0, this.getWidth(), this.getHeight());
                                            g.setColor(Color.BLACK);
                                            g.setFont(new Font("Monospace", Font.BOLD, 15));
                                            g.drawString(randomcard.getNama(),10, this.getHeight()/4);
                                            g.drawImage(Assets.energy,0,0,20,20,null);
                                            g.drawString(String.valueOf(randomcard.getCost()),22,15);

                                            String[] descSplit = randomcard.getDesc().split("\n");
                                            for (int i = 0; i < descSplit.length; i++) {
                                                g.drawString(descSplit[i],10,this.getHeight()/2 + ( i*30));
                                            }
                                            super.paintComponent(g);
                                        }
                                    };
                                    card.setVerticalAlignment(card.TOP);
                                    JOptionPane.showMessageDialog(null, "Wow, you get " + Statics.tankerCards.get(random).getNama());
                                } else if (kapal instanceof Warship) {
                                    random = (int) (Math.random() * Statics.warshipCards.size());
                                    kapal.addCard(Statics.warshipCards.get(random).copy());
                                    JOptionPane.showMessageDialog(null, "Wow, you get " + Statics.warshipCards.get(random).getNama());
                                } else {
                                    random = (int) (Math.random() * Statics.aircraftCards.size());
                                    kapal.addCard(Statics.aircraftCards.get(random).copy());
                                    JOptionPane.showMessageDialog(null, "Wow, you get " + Statics.aircraftCards.get(random).getNama());
                                }
                            }
//                            if (random < 7) {
//                                //70% ZONK
//                                card.setText("X");
//                                card.setForeground(Color.red);
//                                card.setOpaque(false);
//                                JOptionPane.showMessageDialog(null, "Sadly, you get nothing");
//                            } else if (random < 8) {
//                                //10% CARD
//                                if (kapal instanceof Tanker) {
//                                    random = (int) (Math.random() * Statics.tankerCards.size());
//                                    kapal.addCard(Statics.tankerCards.get(random).copy());
//                                    JOptionPane.showMessageDialog(null, "Wow, you get " + Statics.tankerCards.get(random).getNama());
//                                } else if (kapal instanceof Warship) {
//                                    random = (int) (Math.random() * Statics.warshipCards.size());
//                                    kapal.addCard(Statics.warshipCards.get(random).copy());
//                                    JOptionPane.showMessageDialog(null, "Wow, you get " + Statics.warshipCards.get(random).getNama());
//                                } else {
//                                    random = (int) (Math.random() * Statics.aircraftCards.size());
//                                    kapal.addCard(Statics.aircraftCards.get(random).copy());
//                                    JOptionPane.showMessageDialog(null, "Wow, you get " + Statics.aircraftCards.get(random).getNama());
//                                }
//                            } else if (random < 9) {
//                                //10% POTION
//                                random = (int) (Math.random() * 10);
//                                if (random < 9) {
//                                    //90% Uncommon
//                                    random = (int) (Math.random() * Statics.uncommonPotion.size());
//                                    kapal.addPotion(Statics.uncommonPotion.get(random).copy());
//                                    JOptionPane.showMessageDialog(null, "Wow, you get " + Statics.uncommonPotion.get(random).getNama());
//                                } else {
//                                    //10% Rare
//                                    random = (int) (Math.random() * Statics.rarePotion.size());
//                                    kapal.addPotion(Statics.rarePotion.get(random).copy());
//                                    JOptionPane.showMessageDialog(null, "Wow, you get " + Statics.rarePotion.get(random).getNama());
//                                }
//                            } else {
//                                //10% RELIC
//                                random = (int) (Math.random() * 10);
//                                if (random < 9) {
//                                    //90% Uncommon
//                                    random = (int) (Math.random() * Statics.uncommonRelic.size());
//                                    kapal.addRelic(Statics.uncommonRelic.get(random).copy());
//                                    JOptionPane.showMessageDialog(null, "Wow, you get " + Statics.uncommonRelic.get(random).getNama());
//                                } else {
//                                    //10% Rare
//                                    random = (int) (Math.random() * Statics.rareRelic.size());
//                                    kapal.addRelic(Statics.rareRelic.get(random).copy());
//                                    JOptionPane.showMessageDialog(null, "Wow, you get " + Statics.rareRelic.get(random).getNama());
//                                }
//                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "You don't have enough coin", "Access Denied", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "You already used this menu once", "Access Denied", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                drawbutton.setForeground(Color.red);
                drawbutton.setBorder(BorderFactory.createLineBorder(Color.red));
                drawbutton.setLocation(drawbutton.getX() + 2, drawbutton.getY() - 2);
                drawbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                drawbutton.setForeground(Color.green);
                drawbutton.setBorder(null);
                drawbutton.setLocation(drawbutton.getX() - 2, drawbutton.getY() + 2);
            }
        });
        add(drawbutton);

        //PERCENTAGE LIST
        percentagelist.setBounds(this.getWidth()/2 + space, height + 10 + space,this.getWidth()/2 - space*2, (int) (height * 1.6) + 11);
        add(percentagelist);

        //BACKGROUND
        bg.setBounds(0, 0,1162,648);
        add(bg);
    }
}
