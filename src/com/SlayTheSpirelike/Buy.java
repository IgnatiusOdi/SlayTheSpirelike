package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buy extends JPanel {

    private Body body;
    private Shop shop;
    private Kapal kapal;

    //VARIABLE
    int pcoin = 1000;

    //SIZE
    private final int width = 290;
    private final int height = 162;
    private final int space = 25;

    //IMAGE
    private final Image hangingsign = new ImageIcon("resources/hangingsign.png").getImage();
    private final Image wood = new ImageIcon("resources/woodtextures.jpg").getImage();
    private final Image woodbg = new ImageIcon("resources/woodbg.jpg").getImage();
    private final Image black = new ImageIcon("resources/black.png").getImage();

    //PROPERTIES
    private JLabel bg;
    private JLabel title;
    private JLabel coinsymbol;
    private JLabel coin;
    private JLabel playercoin;
    private JLabel back;

    private JLabel card1;
    private JButton card1button;
    private Boolean card1bought;
    private JLabel card1layer;
    private int card1price;

    private JLabel card2;
    private JButton card2button;
    private Boolean card2bought;
    private JLabel card2layer;
    private int card2price;

    private JLabel card3;
    private JButton card3button;
    private Boolean card3bought;
    private JLabel card3layer;
    private int card3price;

    private JLabel relic1;
    private JButton relic1button;
    private Boolean relic1bought;
    private JLabel relic1layer;
    private int relic1price;

    private JLabel relic2;
    private JButton relic2button;
    private Boolean relic2bought;
    private JLabel relic2layer;
    private int relic2price;

    private JLabel relic3;
    private JButton relic3button;
    private Boolean relic3bought;
    private JLabel relic3layer;
    private int relic3price;

    public Buy(Body body, Shop shop, Kapal kapal) {
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
        title = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(hangingsign,0,0,width,height,null);
                g.drawString("BUY",70,135);
                g.setColor(Color.green);
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
        coinsymbol = new JLabel("C") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(black,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        coin = new JLabel("COIN : "){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0,105,50,null);
                super.paintComponent(g);
            }
        };
        playercoin = new JLabel(String.valueOf(pcoin)){
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

        card1 = new JLabel("CARD 1") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(black,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        card1button = new JButton();
        card1bought = false;
        card1layer = new JLabel();
        card1price = 100;

        card2 = new JLabel("CARD 2") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(black,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        card2button = new JButton();
        card2bought = false;
        card2layer = new JLabel();
        card2price = 200;

        card3 = new JLabel("CARD 3") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(black,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        card3button = new JButton();
        card3bought = false;
        card3layer = new JLabel();
        card3price = 300;

        relic1 = new JLabel("RELIC 1") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(black,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        relic1button = new JButton();
        relic1bought = false;
        relic1layer = new JLabel();
        relic1price = 400;

        relic2 = new JLabel("RELIC 2") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(black,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        relic2button = new JButton();
        relic2bought = false;
        relic2layer = new JLabel();
        relic2price = 500;

        relic3 = new JLabel("RELIC 3") {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(black,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        relic3button = new JButton();
        relic3bought = false;
        relic3layer = new JLabel();
        relic3price = 600;

        //---------------------------------------------------------------------------------------------//

        //TITLE
        title.setBounds(this.getWidth()/2 - width/2,0,width,height);
        title.setFont(new Font("Monospace", Font.ITALIC + Font.BOLD, 70));
        title.setForeground(Color.green);
        add(title);

        //COIN SYMBOL
        coinsymbol.setBounds(830,80,50,50);
        coinsymbol.setHorizontalAlignment(SwingConstants.CENTER);
        coinsymbol.setVerticalAlignment(SwingConstants.CENTER);
        coinsymbol.setForeground(Color.white);
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

        //CARD 1 LAYER
        card1layer.setBounds(space, (int) (height*1.4), height, width);
        card1layer.setBackground(new Color(211,211,211,100));
        card1layer.setOpaque(true);
        card1layer.setVisible(false);
        add(card1layer);

        //CARD 2 LAYER
        card2layer.setBounds((height + space) + space, (int) (height*1.4), height, width);
        card2layer.setBackground(new Color(211,211,211,100));
        card2layer.setOpaque(true);
        card2layer.setVisible(false);
        add(card2layer);

        //CARD 3 LAYER
        card3layer.setBounds((height + space)*2 + space, (int) (height*1.4), height, width);
        card3layer.setBackground(new Color(211,211,211,100));
        card3layer.setOpaque(true);
        card3layer.setVisible(false);
        add(card3layer);

        //RELIC 1 LAYER
        relic1layer.setBounds((height + space)*3 + space, (int) (height*1.4), height, width);
        relic1layer.setBackground(new Color(211,211,211,100));
        relic1layer.setOpaque(true);
        relic1layer.setVisible(false);
        add(relic1layer);

        //RELIC 2 LAYER
        relic2layer.setBounds((height + space)*4 + space, (int) (height*1.4), height, width);
        relic2layer.setBackground(new Color(211,211,211,100));
        relic2layer.setOpaque(true);
        relic2layer.setVisible(false);
        add(relic2layer);

        //RELIC 3 LAYER
        relic3layer.setBounds((height + space)*5 + space, (int) (height*1.4), height, width);
        relic3layer.setBackground(new Color(211,211,211,100));
        relic3layer.setOpaque(true);
        relic3layer.setVisible(false);
        add(relic3layer);

        //CARD 1 BUTTON
        card1button.setBorderPainted(false);
        card1button.setBounds(space,(int) (height*1.4) + width - 50, height, 50);
        card1button.setText(String.valueOf(card1price));
        card1button.setHorizontalTextPosition(JButton.CENTER);
        card1button.setVerticalTextPosition(JButton.CENTER);
        card1button.setFont(new Font("Monospace",Font.ITALIC,20));
        card1button.setForeground(Color.black);
        card1button.setBackground(new Color(211,211,211));
        card1button.setVisible(false);
        card1button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (pcoin >= card1price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"CARD BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        card1.setEnabled(false);
                        card1bought = true;
                        card1layer.setVisible(true);
                        pcoin -= card1price;
                        playercoin.setText(String.valueOf(pcoin));
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                card1button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card1button.setVisible(false);
            }
        });
        add(card1button);

        //CARD 2 BUTTON
        card2button.setBorderPainted(false);
        card2button.setBounds((height + space) + space,(int) (height*1.4) + width - 50, height, 50);
        card2button.setText(String.valueOf(card2price));
        card2button.setHorizontalTextPosition(JButton.CENTER);
        card2button.setVerticalTextPosition(JButton.CENTER);
        card2button.setFont(new Font("Monospace",Font.ITALIC,20));
        card2button.setForeground(Color.black);
        card2button.setBackground(new Color(211,211,211));
        card2button.setVisible(false);
        card2button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (pcoin >= card2price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"CARD BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        card2.setEnabled(false);
                        card2bought = true;
                        card2layer.setVisible(true);
                        pcoin -= card2price;
                        playercoin.setText(String.valueOf(pcoin));
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                card2button.setVisible(true);
                card2button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card2button.setVisible(false);
            }
        });
        add(card2button);

        //CARD 3 BUTTON
        card3button.setBorderPainted(false);
        card3button.setBounds((height + space)*2 + space,(int) (height*1.4) + width - 50, height, 50);
        card3button.setText(String.valueOf(card3price));
        card3button.setHorizontalTextPosition(JButton.CENTER);
        card3button.setVerticalTextPosition(JButton.CENTER);
        card3button.setFont(new Font("Monospace",Font.ITALIC,20));
        card3button.setForeground(Color.black);
        card3button.setBackground(new Color(211,211,211));
        card3button.setVisible(false);
        card3button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHECK MONEY
                    if (pcoin >= card3price) {
                        //SUCCESS
                        JOptionPane.showMessageDialog(null,"CARD BOUGHT", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        card3.setEnabled(false);
                        card3bought = true;
                        card3layer.setVisible(true);
                        pcoin -= card3price;
                        playercoin.setText(String.valueOf(pcoin));
                    } else {
                        //FAILED
                        JOptionPane.showMessageDialog(null,"You don't have enough coin", "FAILED", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                card3button.setVisible(true);
                card3button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card3button.setVisible(false);
            }
        });
        add(card3button);

        //CARD 1
        card1.setBounds(space, (int) (height*1.4), height, width);
        card1.setForeground(Color.white);
        card1.setHorizontalAlignment(SwingConstants.CENTER);
        card1.setVerticalAlignment(SwingConstants.CENTER);
        card1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!card1bought) {
                    card1button.setVisible(true);
                    card1button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card1button.setVisible(false);
            }
        });
        add(card1);

        //CARD 2
        card2.setBounds((height + space) + space, (int) (height*1.4), height, width);
        card2.setForeground(Color.white);
        card2.setHorizontalAlignment(SwingConstants.CENTER);
        card2.setVerticalAlignment(SwingConstants.CENTER);
        card2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card2button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card2button.setVisible(false);
            }
        });
        add(card2);

        //CARD 3
        card3.setBounds((height + space)*2 + space, (int) (height*1.4), height, width);
        card3.setForeground(Color.white);
        card3.setHorizontalAlignment(SwingConstants.CENTER);
        card3.setVerticalAlignment(SwingConstants.CENTER);
        card3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card3button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card3button.setVisible(false);
            }
        });
        add(card3);

        //RELIC 1 BUTTON
        relic1button.setBorderPainted(false);
        relic1button.setBounds((height + space)*3 + space,(int) (height*1.4) + width - 50, height, 50);
        relic1button.setText("100");
        relic1button.setHorizontalTextPosition(JButton.CENTER);
        relic1button.setVerticalTextPosition(JButton.CENTER);
        relic1button.setFont(new Font("Monospace",Font.ITALIC,20));
        relic1button.setForeground(Color.green);
        relic1button.setBackground(new Color(216,252,168));
        relic1button.setVisible(false);
        relic1button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null,"You don't have enough coin", "", JOptionPane.ERROR_MESSAGE);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                relic1button.setVisible(true);
                relic1button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                relic1button.setVisible(false);
            }
        });
        add(relic1button);

        //RELIC 1
        relic1.setBounds((height + space)*3 + space, (int) (height*1.4), height, width);
        relic1.setBackground(Color.yellow);
        relic1.setHorizontalAlignment(SwingConstants.CENTER);
        relic1.setVerticalAlignment(SwingConstants.CENTER);
        relic1.setOpaque(true);
        relic1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                relic1button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                relic1button.setVisible(false);
            }
        });
        add(relic1);

        //RELIC 2 BUTTON
        relic2button.setBorderPainted(false);
        relic2button.setBounds((height + space)*4 + space,(int) (height*1.4) + width - 50, height, 50);
        relic2button.setText("200");
        relic2button.setHorizontalTextPosition(JButton.CENTER);
        relic2button.setVerticalTextPosition(JButton.CENTER);
        relic2button.setFont(new Font("Monospace",Font.ITALIC,20));
        relic2button.setForeground(Color.green);
        relic2button.setBackground(new Color(216,252,168));
        relic2button.setVisible(false);
        relic2button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null,"You don't have enough coin", "", JOptionPane.ERROR_MESSAGE);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                relic2button.setVisible(true);
                relic2button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                relic2button.setVisible(false);
            }
        });
        add(relic2button);

        //RELIC 2
        relic2.setBounds((height + space)*4 + space, (int) (height*1.4), height, width);
        relic2.setBackground(Color.yellow);
        relic2.setHorizontalAlignment(SwingConstants.CENTER);
        relic2.setVerticalAlignment(SwingConstants.CENTER);
        relic2.setOpaque(true);
        relic2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                relic2button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                relic2button.setVisible(false);
            }
        });
        add(relic2);

        //RELIC 3 BUTTON
        relic3button.setBorderPainted(false);
        relic3button.setBounds((height + space)*5 + space,(int) (height*1.4) + width - 50, height, 50);
        relic3button.setText("300");
        relic3button.setHorizontalTextPosition(JButton.CENTER);
        relic3button.setVerticalTextPosition(JButton.CENTER);
        relic3button.setFont(new Font("Monospace",Font.ITALIC,20));
        relic3button.setForeground(Color.green);
        relic3button.setBackground(new Color(216,252,168));
        relic3button.setVisible(false);
        relic3button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "You sure buying this one?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null,"You don't have enough coin", "", JOptionPane.ERROR_MESSAGE);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                relic3button.setVisible(true);
                relic3button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                relic3button.setVisible(false);
            }
        });
        add(relic3button);

        //RELIC 3
        relic3.setBounds((height + space)*5 + space, (int) (height*1.4), height, width);
        relic3.setBackground(Color.yellow);
        relic3.setHorizontalAlignment(SwingConstants.CENTER);
        relic3.setVerticalAlignment(SwingConstants.CENTER);
        relic3.setOpaque(true);
        relic3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                relic3button.setVisible(true);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                relic3button.setVisible(false);
            }
        });
        add(relic3);

        //BACKGROUND
        bg.setBounds(0, 0,1162,648);
        add(bg);
    }
}
