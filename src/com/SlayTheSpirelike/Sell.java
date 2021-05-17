package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sell extends JPanel {

    private Body body;
    private Shop shop;
    private Kapal kapal;

    //SIZE
    private final int width = 290;
    private final int height = 162;
    private final int space = 25;

    //IMAGE
    private final Image hangingsign = new ImageIcon("resources/hangingsign.png").getImage();
    private final Image wood = new ImageIcon("resources/woodtextures.jpg").getImage();
    private final Image woodbg = new ImageIcon("resources/woodbg.jpg").getImage();

    //PROPERTIES
    private JPanel panel;
    private JLabel bg;
    private JLabel title;
    private JLabel cardtitle;
    private JLabel relictitle;

    private JPanel scrollpane;


    private JLabel coinsymbol;
    private JLabel coin;
    private JLabel playercoin;
    private JLabel back;

    public Sell(Body body, Shop shop, Kapal kapal) {
        this.body = body;
        this.shop = shop;
        this.kapal = kapal;
        init();
    }

    private void init() {
        setLayout(null);
        setSize(new Dimension(1162,648));
        setVisible(true);

        //INIT
        panel = new JPanel();
        bg = new JLabel();
        title = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(hangingsign,0,0,width,height,null);
                g.drawString("SELL", 60, 135);
                g.setColor(Color.red);
                super.paintComponent(g);
            }
        };
        cardtitle = new JLabel("CARD"){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0,this.getWidth(),50,null);
                super.paintComponent(g);
            }
        };
        relictitle = new JLabel("RELIC"){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0,this.getWidth(),50,null);
                super.paintComponent(g);
            }
        };
        coinsymbol = new JLabel();
        coin = new JLabel("COIN : "){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0,105,50,null);
                super.paintComponent(g);
            }
        };
        playercoin = new JLabel("0"){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0,100,50,null);
                super.paintComponent(g);
            }
        };
        back = new JLabel("<< BACK"){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0,180,90,null);
                super.paintComponent(g);
            }
        };

        //PANEL
        panel.setLayout(null);
        panel.setSize(1162,648);

        //TITLE
        title.setBounds(this.getWidth()/2 - width/2,0,width,height);
        title.setFont(new Font("Monospace", Font.ITALIC + Font.BOLD, 65));
        title.setForeground(Color.red);
        panel.add(title);

        //CARD TITLE
        cardtitle.setBounds(0, 200, this.getWidth()/2, 50);
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
        panel.add(cardtitle);

        //CARD

        //RELIC TITLE
        relictitle.setBounds(this.getWidth()/2, 200, this.getWidth()/2, 50);
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
        panel.add(relictitle);

        //RELIC

        //COIN SYMBOL
        coinsymbol.setBounds(830,80,50,50);
        coinsymbol.setBackground(Color.yellow);
        coinsymbol.setOpaque(true);
        panel.add(coinsymbol);

        //COIN
        coin.setBounds(880, 80, 105,50);
        coin.setFont(new Font("Monospace", Font.BOLD,30));
        coin.setForeground(Color.white);
        panel.add(coin);

        //PLAYER COIN
        playercoin.setBounds(983,80,100,50);
        playercoin.setFont(new Font("Monospace",Font.BOLD,30));
        playercoin.setForeground(Color.white);
        panel.add(playercoin);

        //BACK
        back.setBounds(height-20,70,180,90);
        back.setForeground(Color.white);
        back.setFont(new Font("Monospace", Font.BOLD,30));
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.setVerticalAlignment(SwingConstants.CENTER);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
        panel.add(back);

        //BACKGROUND
        bg = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(woodbg,0,0,1162,648,null);
                super.paintComponent(g);
            }
        };
        bg.setBounds(0, 0,1162,648);
        panel.add(bg);

        add(panel);
    }
}
