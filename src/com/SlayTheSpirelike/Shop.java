package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends JPanel {

    private Body body;
    private Kapal kapal;

    //BUTTON
    private final int button_width = 240;
    private final int button_height = 90;
    private final int button_x = 50;
    private final int button_y = 50;
    private final int spacing = 50;

    //FONT
    private final int fontsize = 35;

    //IMAGE
    private final Image desainshop = new ImageIcon("resources/desainshop.png").getImage();
    private final Image wood = new ImageIcon("resources/woodtextures.jpg").getImage();
    private final Image black = new ImageIcon("resources/black.png").getImage();

    //LAYOUT
    private JLabel bg;
    private JLabel buyButton;
    private JLabel sellButton;
    private JLabel drawButton;
    private JLabel upgradeButton;
    private JLabel mergeButton;
    private JLabel exitShop;

    public Shop(Body body) {
        this.body = body;
        init();
    }

    private void init() {
        setLayout(null);
        setSize(1162,648);
        setBackground(new Color(135, 206, 235));
        setOpaque(true);
        setVisible(true);

        Buy b = new Buy(this.body, this, this.kapal);
        Sell s = new Sell(this.body, this, this.kapal);
        Draw d = new Draw(this.body, this, this.kapal);
        Upgrade u = new Upgrade(this.body, this, this.kapal);
        Merge m = new Merge(this.body, this, this.kapal);

        //INIT
        bg = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(desainshop,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        buyButton = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        sellButton = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        drawButton = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        upgradeButton = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        mergeButton = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        exitShop = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };

        //BUY
        buyButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        buyButton.setBounds(button_x, button_y, button_width, button_height);
        buyButton.setText("BUY");
        buyButton.setHorizontalAlignment(SwingConstants.CENTER);
        buyButton.setVerticalAlignment(SwingConstants.CENTER);
        buyButton.setFont(new Font("Calibri", Font.BOLD, fontsize));
        buyButton.setForeground(Color.white);
        buyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                body.setPanel(b);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                buyButton.setBorder(BorderFactory.createBevelBorder(0, Color.orange, Color.green, Color.green, Color.orange));
                buyButton.setLocation(buyButton.getX() + 3, buyButton.getY() - 3);
                buyButton.setForeground(Color.green);
                buyButton.setBackground(Color.black);
                buyButton.setOpaque(true);
                buyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                buyButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                buyButton.setLocation(buyButton.getX() - 3, buyButton.getY() + 3);
                buyButton.setForeground(Color.white);
                buyButton.setOpaque(false);
            }
        });
        add(buyButton);

        //SELL
        sellButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        sellButton.setBounds(button_x, button_y + button_height + spacing, button_width, button_height);
        sellButton.setText("SELL");
        sellButton.setHorizontalAlignment(SwingConstants.CENTER);
        sellButton.setVerticalAlignment(SwingConstants.CENTER);
        sellButton.setFont(new Font("Calibri", Font.BOLD, fontsize));
        sellButton.setForeground(Color.white);
        sellButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                body.setPanel(s);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                sellButton.setBorder(BorderFactory.createBevelBorder(0, Color.orange, Color.red, Color.red, Color.orange));
                sellButton.setLocation(sellButton.getX() + 3, sellButton.getY() - 3);
                sellButton.setForeground(Color.red);
                sellButton.setBackground(Color.black);
                sellButton.setOpaque(true);
                sellButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                sellButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                sellButton.setLocation(sellButton.getX() - 3, sellButton.getY() + 3);
                sellButton.setForeground(Color.white);
                sellButton.setOpaque(false);
            }
        });
        add(sellButton);

        //DRAW
        drawButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        drawButton.setBounds(button_x, button_y + (button_height + spacing)*2, button_width, button_height);
        drawButton.setText("DRAW");
        drawButton.setHorizontalAlignment(SwingConstants.CENTER);
        drawButton.setVerticalAlignment(SwingConstants.CENTER);
        drawButton.setFont(new Font("Calibri",Font.BOLD,fontsize));
        drawButton.setForeground(Color.white);
        drawButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                body.setPanel(d);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                drawButton.setBorder(BorderFactory.createBevelBorder(0, Color.orange, Color.blue, Color.blue, Color.orange));
                drawButton.setLocation(drawButton.getX() + 3, drawButton.getY() - 3);
                drawButton.setForeground(Color.blue);
                drawButton.setBackground(Color.black);
                drawButton.setOpaque(true);
                drawButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                drawButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                drawButton.setLocation(drawButton.getX() - 3, drawButton.getY() + 3);
                drawButton.setForeground(Color.white);
                drawButton.setOpaque(false);
            }
        });
        add(drawButton);

        //UPGRADE
        upgradeButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        upgradeButton.setBounds(button_x + button_width + spacing, button_y + (int) (spacing * 1.5), button_width, button_height);
        upgradeButton.setText("UPGRADE");
        upgradeButton.setHorizontalAlignment(SwingConstants.CENTER);
        upgradeButton.setVerticalAlignment(SwingConstants.CENTER);
        upgradeButton.setFont(new Font("Calibri",Font.BOLD,fontsize));
        upgradeButton.setForeground(Color.white);
        upgradeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                body.setPanel(u);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                upgradeButton.setBorder(BorderFactory.createBevelBorder(0, Color.orange, Color.magenta, Color.magenta, Color.orange));
                upgradeButton.setLocation(upgradeButton.getX() + 3, upgradeButton.getY() - 3);
                upgradeButton.setForeground(Color.magenta);
                upgradeButton.setBackground(Color.black);
                upgradeButton.setOpaque(true);
                upgradeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                upgradeButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                upgradeButton.setLocation(upgradeButton.getX() - 3, upgradeButton.getY() + 3);
                upgradeButton.setForeground(Color.white);
                upgradeButton.setOpaque(false);
            }
        });
        add(upgradeButton);

        //MERGE
        mergeButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        mergeButton.setBounds(button_x + button_width + spacing,button_y + (int) ((button_height + spacing) * 1.5), button_width, button_height);
        mergeButton.setText("MERGE");
        mergeButton.setHorizontalAlignment(SwingConstants.CENTER);
        mergeButton.setVerticalAlignment(SwingConstants.CENTER);
        mergeButton.setFont(new Font("Calibri",Font.BOLD,fontsize));
        mergeButton.setForeground(Color.white);
        mergeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                body.setPanel(m);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                mergeButton.setBorder(BorderFactory.createBevelBorder(0, Color.orange, Color.gray, Color.gray, Color.orange));
                mergeButton.setLocation(mergeButton.getX() + 3, mergeButton.getY() - 3);
                mergeButton.setForeground(Color.gray);
                mergeButton.setBackground(Color.black);
                mergeButton.setOpaque(true);
                mergeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                mergeButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                mergeButton.setLocation(mergeButton.getX() - 3, mergeButton.getY() + 3);
                mergeButton.setForeground(Color.white);
                mergeButton.setOpaque(false);
            }
        });
        add(mergeButton);

        //EXIT
        exitShop.setBounds(460,560,110,40);
        exitShop.setText("<< EXIT");
        exitShop.setFont(new Font("Monospace",Font.BOLD,25));
        exitShop.setHorizontalAlignment(SwingConstants.CENTER);
        exitShop.setVerticalAlignment(SwingConstants.CENTER);
        exitShop.setForeground(Color.white);
        exitShop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Are you sure?", "EXIT", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    body.dispose();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                exitShop.setBorder(BorderFactory.createLineBorder(Color.red,1));
                exitShop.setLocation(exitShop.getX() + 3, exitShop.getY() - 3);
                exitShop.setForeground(Color.red);
                exitShop.setBackground(Color.black);
                exitShop.setOpaque(true);
                exitShop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitShop.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                exitShop.setLocation(exitShop.getX() - 3, exitShop.getY() + 3);
                exitShop.setForeground(Color.white);
                exitShop.setOpaque(false);
            }
        });
        add(exitShop);

        //BACKGROUND
        bg.setBounds(0, 0,1162,648);
        add(bg);
    }
}
