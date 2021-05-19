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
    private final int fontsize = 32;

    //IMAGE
    private final Image wood = new ImageIcon("resources/woodtextures.jpg").getImage();
    private final Image black = new ImageIcon("resources/black.png").getImage();
    private final Image desainshop = new ImageIcon("resources/desainshop.png").getImage();

    //LAYOUT
    private JPanel panel;
    private JLabel bg;
    private JButton buyButton;
    private JButton sellButton;
    private JButton drawButton;
    private JButton upgradeButton;
    private JButton mergeButton;
    private JLabel exitShop;

    public Shop(Body body) {
        setLayout(null);
        setSize(1162,648);
        setVisible(true);

        this.body = body;
        Buy b = new Buy(this.body, this, this.kapal);
        Sell s = new Sell(this.body, this, this.kapal);
        Draw d = new Draw(this.body, this, this.kapal);
        Upgrade u = new Upgrade(this.body, this, this.kapal);
        Merge m = new Merge(this.body, this, this.kapal);

        //INIT
        panel = new JPanel();
        bg = new JLabel();
        buyButton = new JButton();
        sellButton = new JButton();
        drawButton = new JButton();
        upgradeButton = new JButton();
        mergeButton = new JButton();

        //PANEL
        panel.setLayout(null);
        panel.setSize(1162,648);
        panel.setBackground(new Color(135, 206, 235));
        panel.setOpaque(true);

        //BUY
        buyButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        buyButton.setBounds(button_x, button_y, button_width, button_height);
        buyButton.setText("BUY");
        buyButton.setHorizontalTextPosition(JButton.CENTER);
        buyButton.setVerticalTextPosition(JButton.CENTER);
        buyButton.setFont(new Font("Calibri", Font.BOLD, fontsize));
        buyButton.setForeground(Color.white);
        buyButton.setIcon(new ImageIcon(wood));
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                body.setPanel(b);
            }
        });
        buyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buyButton.setBorder(BorderFactory.createBevelBorder(0, Color.orange, Color.green, Color.green, Color.orange));
                buyButton.setLocation(buyButton.getX() + 3, buyButton.getY() - 3);
                buyButton.setIcon(new ImageIcon(black));
                buyButton.setForeground(Color.orange);
                buyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                buyButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                buyButton.setLocation(buyButton.getX() - 3, buyButton.getY() + 3);
                buyButton.setIcon(new ImageIcon(wood));
                buyButton.setForeground(Color.white);
            }
        });
        panel.add(buyButton);

        //SELL
        sellButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        sellButton.setBounds(button_x, button_y + button_height + spacing, button_width, button_height);
        sellButton.setText("SELL");
        sellButton.setHorizontalTextPosition(JButton.CENTER);
        sellButton.setVerticalTextPosition(JButton.CENTER);
        sellButton.setFont(new Font("Calibri", Font.BOLD, fontsize));
        sellButton.setForeground(Color.white);
        sellButton.setIcon(new ImageIcon(wood));
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                body.setPanel(s);
            }
        });
        sellButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sellButton.setBorder(BorderFactory.createBevelBorder(0, Color.orange, Color.red, Color.red, Color.orange));
                sellButton.setLocation(sellButton.getX() + 3, sellButton.getY() - 3);
                sellButton.setIcon(new ImageIcon(black));
                sellButton.setForeground(Color.orange);
                sellButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                sellButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                sellButton.setLocation(sellButton.getX() - 3, sellButton.getY() + 3);
                sellButton.setIcon(new ImageIcon(wood));
                sellButton.setForeground(Color.white);
            }
        });
        panel.add(sellButton);

        //DRAW
        drawButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        drawButton.setBounds(button_x, button_y + (button_height + spacing)*2, button_width, button_height);
        drawButton.setText("DRAW");
        drawButton.setHorizontalTextPosition(JButton.CENTER);
        drawButton.setVerticalTextPosition(JButton.CENTER);
        drawButton.setFont(new Font("Calibri",Font.BOLD,fontsize));
        drawButton.setForeground(Color.white);
        drawButton.setIcon(new ImageIcon(wood));
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                body.setPanel(d);
            }
        });
        drawButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                drawButton.setBorder(BorderFactory.createBevelBorder(0, Color.orange, Color.blue, Color.blue, Color.orange));
                drawButton.setLocation(drawButton.getX() + 3, drawButton.getY() - 3);
                drawButton.setIcon(new ImageIcon(black));
                drawButton.setForeground(Color.orange);
                drawButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                drawButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                drawButton.setLocation(drawButton.getX() - 3, drawButton.getY() + 3);
                drawButton.setIcon(new ImageIcon(wood));
                drawButton.setForeground(Color.white);
            }
        });
        panel.add(drawButton);

        //UPGRADE
        upgradeButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        upgradeButton.setBounds(button_x + button_width + spacing, button_y + (int) (spacing * 1.5), button_width, button_height);
        upgradeButton.setText("UPGRADE");
        upgradeButton.setHorizontalTextPosition(JButton.CENTER);
        upgradeButton.setVerticalTextPosition(JButton.CENTER);
        upgradeButton.setFont(new Font("Calibri",Font.BOLD,fontsize));
        upgradeButton.setForeground(Color.white);
        upgradeButton.setIcon(new ImageIcon(wood));
        upgradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                body.setPanel(u);
            }
        });
        upgradeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                upgradeButton.setBorder(BorderFactory.createBevelBorder(0, Color.orange, Color.magenta, Color.magenta, Color.orange));
                upgradeButton.setLocation(upgradeButton.getX() + 3, upgradeButton.getY() - 3);
                upgradeButton.setIcon(new ImageIcon(black));
                upgradeButton.setForeground(Color.orange);
                upgradeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                upgradeButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                upgradeButton.setLocation(upgradeButton.getX() - 3, upgradeButton.getY() + 3);
                upgradeButton.setIcon(new ImageIcon(wood));
                upgradeButton.setForeground(Color.white);
            }
        });
        panel.add(upgradeButton);

        //MERGE
        mergeButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        mergeButton.setBounds(button_x + button_width + spacing,button_y + (int) ((button_height + spacing) * 1.5), button_width, button_height);
        mergeButton.setText("MERGE");
        mergeButton.setHorizontalTextPosition(JButton.CENTER);
        mergeButton.setVerticalTextPosition(JButton.CENTER);
        mergeButton.setFont(new Font("Calibri",Font.BOLD,fontsize));
        mergeButton.setForeground(Color.white);
        mergeButton.setIcon(new ImageIcon(wood));
        mergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                body.setPanel(m);
            }
        });
        mergeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mergeButton.setBorder(BorderFactory.createBevelBorder(0, Color.orange, Color.gray, Color.gray, Color.orange));
                mergeButton.setLocation(mergeButton.getX() + 3, mergeButton.getY() - 3);
                mergeButton.setIcon(new ImageIcon(black));
                mergeButton.setForeground(Color.orange);
                mergeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                mergeButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                mergeButton.setLocation(mergeButton.getX() - 3, mergeButton.getY() + 3);
                mergeButton.setIcon(new ImageIcon(wood));
                mergeButton.setForeground(Color.white);
            }
        });
        panel.add(mergeButton);

        //EXIT
        exitShop = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(wood,0,0,110,40,null);
                super.paintComponent(g);
            }
        };
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
                exitShop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitShop.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                exitShop.setLocation(exitShop.getX() - 3, exitShop.getY() + 3);
                exitShop.setForeground(Color.white);
            }
        });
        panel.add(exitShop);

        //BACKGROUND
        bg.setIcon(new ImageIcon(desainshop));
        bg.setBounds(0, 0,1162,648);
        panel.add(bg);

        add(panel);
    }
}
