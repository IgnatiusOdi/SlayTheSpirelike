package com.SlayTheSpirelike.ShopDivisions;

import com.SlayTheSpirelike.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

public class Sell extends JPanel{

    private Body body;
    private Shop shop;
    private Kapal kapal;

    //COUNTER
    int sellcardcounter = 1;
    int sellreliccounter = 1;

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
    private JLabel cardtitle;
    private JLabel relictitle;
    private JScrollPane scroll;
    private JPanel cardplace;
    private JPanel relicplace;
    private JLabel coinsymbol;
    private JLabel coinplayer;
    private JLabel back;

    public Sell(Body body, Shop shop, Kapal kapal) {
        this.body = body;
        this.shop = shop;
        this.kapal = kapal;
        init();
        showCard();
        showRelic();
        initCheats();
    }

    public void refresh() {
        showCard();
        showRelic();
        coinplayer.setText(String.valueOf(kapal.getCoin()));
    }

    private void showCard() {
        cardplace.removeAll();
        int cardheight = 220 * (1 + (kapal.getCard().size()/5));
        cardplace.setPreferredSize(new Dimension(this.getWidth() - 20, cardheight));
        ArrayList<JLabel> cards = new ArrayList<>();
        for (int i = 0; i < kapal.getCard().size(); i++) {
            Card mycard = kapal.getCard(i);
            cards.add(new JLabel() {
                @Override
                protected void paintComponent(Graphics g) {
                    switch (mycard.getType()) {
                        case "Self" -> g.setColor(Color.BLUE);
                        case "Enemy" -> g.setColor(Color.GREEN);
                        case "Battle" -> g.setColor(Color.MAGENTA);
                    }
                    g.fillRect(0,0, this.getWidth(), this.getHeight());
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Monospace", Font.BOLD, 15));
                    g.drawString(mycard.getNama(),10, this.getHeight()/4);
                    g.drawImage(Assets.energy,0,0,20,20,null);
                    g.drawString(String.valueOf(mycard.getCost()),22,15);

                    String[] descSplit = mycard.getDesc().split("\n");
                    for (int i = 0; i < descSplit.length; i++) {
                        g.drawString(descSplit[i],10,this.getHeight()/2 + ( i*30));
                    }
                    super.paintComponent(g);
                }
            });
            // TODO: 09/06/2021 Mouse Listener Overlap
            cards.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (((Card)e.getSource()).getBattle()==null && !e.isConsumed()){
                        int n = JOptionPane.showConfirmDialog(null, "You will get 50C for selling this card! Are you sure?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION) {
                            if (sellcardcounter == 0) {
                                kapal.setCoin(kapal.getCoin() + 50);
                                coinplayer.setText(String.valueOf(kapal.getCoin()));
                                kapal.getCard().remove(mycard);
                                sellcardcounter++;
                                JOptionPane.showMessageDialog(null,"You got 50C");
                                showCard();
                            } else {
                                JOptionPane.showMessageDialog(null, "You already sold card once", "Access Denied", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    e.consume();
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    mycard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    mycard.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            });
            cards.get(i).setPreferredSize(new Dimension(width, height));
            cardplace.add(cards.get(i));
        }
        cardplace.repaint();
        cardplace.revalidate();
    }

    private void showRelic() {
        relicplace.removeAll();
        int relicheight = 155 * (1 + (kapal.getRelic().size()/5));
        relicplace.setPreferredSize(new Dimension(this.getWidth() - 20, relicheight));
        ArrayList<JLabel> relics = new ArrayList<>();
        for (int i = 0; i < kapal.getRelic().size(); i++) {
            Relic myrelic = kapal.getRelic(i);
            relics.add(new JLabel() {
                @Override
                protected void paintComponent(Graphics g) {
                    g.setColor(Color.blue);
                    g.fillRect(0,0, this.getWidth(), this.getHeight());
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Monospace", Font.BOLD, 15));
                    g.drawString(myrelic.getNama(),10, this.getHeight()/4);

                    String[] descSplit = myrelic.getDesc().split("\n");
                    for (int i = 0; i < descSplit.length; i++) {
                        g.drawString(descSplit[i],10,this.getHeight()/2 + ( i*30));
                    }
                    super.paintComponent(g);
                }
            });
            myrelic.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int n;
                    if (myrelic.getRarity().equals("Common")) {
                        n = JOptionPane.showConfirmDialog(null, "You will get 75C for selling this relic! Are you sure?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                    } else if (myrelic.getRarity().equals("Uncommon")) {
                        n = JOptionPane.showConfirmDialog(null, "You will get 150C for selling this relic! Are you sure?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                    } else if (myrelic.getRarity().equals("Rare")) {
                        n = JOptionPane.showConfirmDialog(null, "You will get 300C for selling this card! Are you sure?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                    } else if (myrelic.getRarity().equals("Shop")) {
                        n = JOptionPane.showConfirmDialog(null, "You will get 150C for selling this card! Are you sure?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                    } else {
                        n = JOptionPane.showConfirmDialog(null, "You will get 1000C for selling this card! Are you sure?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                    }
                    if (n == JOptionPane.YES_OPTION) {
                        if (sellreliccounter == 0) {
                            if (myrelic.getRarity().equals("Common")) {
                                kapal.setCoin(kapal.getCoin() + 75);
                                JOptionPane.showMessageDialog(null,"You got 75C");
                            } else if (myrelic.getRarity().equals("Uncommon")) {
                                kapal.setCoin(kapal.getCoin() + 150);
                                JOptionPane.showMessageDialog(null,"You got 150C");
                            } else if (myrelic.getRarity().equals("Rare")) {
                                kapal.setCoin(kapal.getCoin() + 300);
                                JOptionPane.showMessageDialog(null,"You got 300C");
                            } else if (myrelic.getRarity().equals("Shop")) {
                                kapal.setCoin(kapal.getCoin() + 150);
                                JOptionPane.showMessageDialog(null,"You got 150C");
                            } else {
                                kapal.setCoin(kapal.getCoin() + 300);
                                JOptionPane.showMessageDialog(null,"You got 1000C");
                            }
                            coinplayer.setText(String.valueOf(kapal.getCoin()));
                            kapal.getRelic().remove(myrelic);
                            sellreliccounter++;
                            showRelic();
                        } else {
                            JOptionPane.showMessageDialog(null, "You already sold relic once", "Access Denied", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    myrelic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    myrelic.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            });
            relics.get(i).setPreferredSize(new Dimension(width, height));
            relicplace.add(relics.get(i));
        }
        relicplace.repaint();
        relicplace.revalidate();
    }

    private void init() {
        setLayout(null);
        setSize(new Dimension(1162,648));
        setVisible(true);

        //INIT
        title = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(hangingsign,0,0, this.getWidth(), this.getHeight(),null);
                g.setColor(Color.red);
                g.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 75));
                g.drawString("SELL",110,138);
                super.paintComponent(g);
            }
        };
        bg = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(woodbg,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        cardtitle = new JLabel("CARD") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        relictitle = new JLabel("RELIC") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        cardplace = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        relicplace = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        scroll = new JScrollPane(cardplace, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        coinsymbol = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(coinimg,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        coinplayer = new JLabel(String.valueOf(kapal.getCoin()));
        back = new JLabel("<< BACK"){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
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

        //CARD TITLE
        cardtitle.setBounds(0, 165, this.getWidth()/2, 50);
        cardtitle.setBorder(BorderFactory.createLineBorder(Color.red,2));
        cardtitle.setHorizontalAlignment(SwingConstants.CENTER);
        cardtitle.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 30));
        cardtitle.setForeground(Color.white);
        cardtitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardtitle.setBorder(BorderFactory.createLineBorder(Color.red,2));
                cardtitle.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 30));
                relictitle.setBorder(BorderFactory.createEmptyBorder());
                relictitle.setFont(new Font("Monospace", Font.PLAIN, 25));

                scroll.setViewportView(cardplace);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                cardtitle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                cardtitle.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cardtitle.setForeground(Color.white);
            }
        });
        add(cardtitle);

        //RELIC TITLE
        relictitle.setBounds(this.getWidth()/2, 165, this.getWidth()/2, 50);
        relictitle.setHorizontalAlignment(SwingConstants.CENTER);
        relictitle.setFont(new Font("Monospace", Font.PLAIN, 25));
        relictitle.setForeground(Color.white);
        relictitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardtitle.setBorder(BorderFactory.createEmptyBorder());
                cardtitle.setFont(new Font("Monospace", Font.PLAIN, 25));
                relictitle.setBorder(BorderFactory.createLineBorder(Color.red,2));
                relictitle.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 30));

                scroll.setViewportView(relicplace);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                relictitle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                relictitle.setForeground(Color.red);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                relictitle.setForeground(Color.white);
            }
        });
        add(relictitle);

        //SCROLL
        scroll.setBounds(0, 215, this.getWidth(), 430);
        scroll.setViewportView(cardplace);
        add(scroll);

        //CARD PLACE
        cardplace.setBounds(0, 0, this.getWidth() - 20, 350);
        cardplace.setLayout(new FlowLayout(FlowLayout.CENTER));
        cardplace.setBackground(Color.yellow);
        cardplace.setOpaque(true);

        //RELIC PLACE
        relicplace.setBounds(0, 0, this.getWidth() - 20, 350);
        relicplace.setLayout(new FlowLayout(FlowLayout.CENTER));
        relicplace.setBackground(Color.red);
        relicplace.setOpaque(true);

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

}
