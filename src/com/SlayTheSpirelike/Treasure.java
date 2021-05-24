package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Treasure extends JPanel {

    private Body body;

    //BUTTON
    private final int width = 400;
    private final int height = 300;
    private final int space = 70;

    //IMAGE
    private final Image treasurepile = new ImageIcon("resources/treasurepile.png").getImage();
    private final Image closechest = new ImageIcon("resources/closechest.png").getImage();
    private final Image openchest = new ImageIcon("resources/openchest.png").getImage();

    //LAYOUT
    private JLabel title;
    private JLabel warning;
    private JLabel bg;
    private JLabel card1;
    private JLabel card1layer;
    private JLabel card2;
    private JLabel card2layer;
    private JLabel card3;
    private JLabel card3layer;
    private JLabel skip;

    public Treasure(Body body) {
        this.body = body;
        init();
    }

    private void init() {
        setLayout(null);
        setSize(1162, 648);
        setBackground(new Color(0, 0, 0));
        setOpaque(true);
        setVisible(true);

        //INIT
        title = new JLabel("GZ!! You found treasures, what would you like to do with them?");
        bg = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(treasurepile,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        warning = new JLabel("WARNING!! YOU MIGHT GET SOMETHING YOU DON'T WANT!!");
        skip = new JLabel("SKIP");

        card1layer = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(openchest,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        card1 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(closechest,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };

        card2layer = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(openchest,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        card2 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(closechest,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };

        card3layer = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(openchest,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        card3 = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(closechest,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };

        //TITLE
        title.setBounds(0, 0, this.getWidth(), 60);
        title.setFont(new Font("Monospace", Font.BOLD, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.yellow);
        title.setBackground(Color.darkGray);
        title.setOpaque(true);
        add(title);

        //WARNING
        warning.setBounds(this.getWidth()/4, 75, (int) (this.getWidth() / 1.9), 50);
        warning.setFont(new Font("Monospace", Font.ITALIC, 20));
        warning.setHorizontalAlignment(SwingConstants.CENTER);
        warning.setVerticalAlignment(SwingConstants.CENTER);
        warning.setForeground(Color.red);
        warning.setBackground(Color.white);
        warning.setOpaque(true);
        add(warning);

        //SKIP
        skip.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        skip.setBounds(this.getWidth()/2 - 70, this.getHeight() - space - 10, 140, 60);
        skip.setFont(new Font("Monospace", Font.BOLD, 35));
        skip.setHorizontalAlignment(SwingConstants.CENTER);
        skip.setVerticalAlignment(SwingConstants.CENTER);
        skip.setForeground(Color.white);
        skip.setBackground(Color.black);
        skip.setOpaque(true);
        skip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "The chance doesn't come twice. Are you sure?", "EXIT", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    body.dispose();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                skip.setBorder(BorderFactory.createLineBorder(Color.black,2));
                skip.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 35));
                skip.setForeground(Color.black);
                skip.setBackground(Color.white);
                skip.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                skip.setBorder(BorderFactory.createLineBorder(Color.white, 2));
                skip.setFont(new Font("Monospace", Font.BOLD, 35));
                skip.setForeground(Color.white);
                skip.setBackground(Color.black);
            }
        });
        add(skip);

        //CARD 1 LAYER
        card1layer.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        card1layer.setBounds(space, space*2, height, width);
        card1layer.setVisible(false);
        card1layer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card1layer.setVisible(false);
                card1.setVisible(true);
            }
        });
        add(card1layer);

        //CARD 1
        card1.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        card1.setBounds(space, space*2, height, width);
        card1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card1layer.setVisible(true);
                card1layer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                card1.setVisible(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
            }
        });
        add(card1);

        //CARD 2 LAYER
        card2layer.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        card2layer.setBounds((height + space) + space, space*2, height, width);
        card2layer.setVisible(false);
        card2layer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card2layer.setVisible(false);
                card2.setVisible(true);
            }
        });
        add(card2layer);

        //CARD 2
        card2.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        card2.setBounds((height + space) + space, space*2, height, width);
        card2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card2layer.setVisible(true);
                card2layer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                card2.setVisible(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
            }
        });
        add(card2);

        //CARD 3 LAYER
        card3layer.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        card3layer.setBounds((height + space)*2 + space, space*2, height, width);
        card3layer.setVisible(false);
        card3layer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card3layer.setVisible(false);
                card3.setVisible(true);
            }
        });
        add(card3layer);

        //CARD 3
        card3.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        card3.setBounds((height + space)*2 + space, space*2, height, width);
        card3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card3layer.setVisible(true);
                card3layer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                card3.setVisible(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
            }
        });
        add(card3);

        //BACKGROUND
        bg.setBounds(0, 50, this.getWidth(), this.getHeight() - 50);
        add(bg);
    }
}
