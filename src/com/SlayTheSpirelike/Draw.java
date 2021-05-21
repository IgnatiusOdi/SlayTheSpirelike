package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Draw extends JPanel {

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
    private JLabel bg;
    private JLabel title;
    private JLabel draw;
    private JLabel card;
    private JLabel drawbutton;
    private JLabel percentagelist;
    private JLabel coinsymbol;
    private JLabel coin;
    private JLabel playercoin;
    private JLabel back;

    public Draw(Body body, Shop shop, Kapal kapal) {
        this.body = body;
        this.shop = shop;
        this.kapal = kapal;
        init();
    }

    private void init() {
        setLayout(null);
        setSize(1162,648);
        setVisible(true);

        //INIT
        bg = new JLabel();
        title = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(hangingsign, 0, 0, this.getWidth(), this.getHeight(),null);
                g.drawString("DRAW", 57, 130);
                g.setColor(Color.blue);
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
        drawbutton = new JLabel(">> Click here to DRAW random <<"){
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
                super.paintComponent(g);
            }
        };
        coinsymbol = new JLabel();
        coin = new JLabel("COIN : ") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        playercoin = new JLabel("0") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        back = new JLabel("<< BACK") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(),this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        bg = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(woodbg,0,0,1162,648,null);
                super.paintComponent(g);
            }
        };

        //TITLE
        title.setBounds(this.getWidth()/2 - width/2,0, width, height);
        title.setFont(new Font("Monospace", Font.ITALIC + Font.BOLD, 55));
        title.setForeground(Color.blue);
        add(title);

        //CARD
        card.setBounds(space*3, (int) (height*1.5), this.getWidth()/2 - space*5, this.getHeight()/2);
        card.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 50));
        card.setHorizontalAlignment(SwingConstants.CENTER);
        card.setForeground(Color.black);
        card.setBackground(Color.white);
        card.setOpaque(true);
        add(card);

        //DRAW
        draw.setBounds(space, (int) (height*1.2), this.getWidth()/2 - space, (int) (this.getHeight()/1.5));
        add(draw);

        //DRAW BUTTON
        drawbutton.setBounds(this.getWidth()/2 + space, (int) (height*1.2), this.getWidth()/2 - space*2, 50);
        drawbutton.setFont(new Font("Monospace", Font.BOLD,30));
        drawbutton.setHorizontalAlignment(SwingConstants.CENTER);
        drawbutton.setForeground(Color.green);
        drawbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Feeling lucky today?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY

                    //DRAW
                    int r = (int) (Math.random()*256);
                    int g = (int) (Math.random()*256);
                    int b = (int) (Math.random()*256);
                    card.setBackground(new Color(r,g,b));
                    card.setText(r + ", " + g + ", " + b);

                    //GIVE CARD / RELIC TO PLAYER

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
        percentagelist.setBounds(this.getWidth()/2 + space, (int) (height*1.7),this.getWidth()/2 - space*2, this.getHeight()/2 + space);
        add(percentagelist);

        //COIN SYMBOL
        coinsymbol.setBounds(830,80,50,50);
        coinsymbol.setBackground(Color.yellow);
        coinsymbol.setOpaque(true);
        add(coinsymbol);

        //COIN
        coin.setBounds(880, 80, 105,50);
        coin.setFont(new Font("Monospace", Font.BOLD,30));
        coin.setForeground(Color.white);
        add(coin);

        //PLAYER COIN
        playercoin.setBounds(983,80,100,50);
        playercoin.setFont(new Font("Monospace",Font.BOLD,30));
        playercoin.setForeground(Color.white);
        add(playercoin);

        //BACK
        back.setBounds(height-20,70,180,90);
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

        //BACKGROUND
        bg.setBounds(0, 0,1162,648);
        add(bg);
    }
}
