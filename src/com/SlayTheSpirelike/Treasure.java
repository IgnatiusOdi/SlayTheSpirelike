package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Treasure extends JPanel {

    private Body body;

    //OPENED CHEST COUNTER
    int counteropened = 0;

    //BUTTON
    private final int width = 400;
    private final int height = 300;
    private final int space = 70;

    //IMAGE
    private final Image treasurepile = new ImageIcon("resources/treasurepile.png").getImage();
    private final Image closechest = new ImageIcon("resources/closechest.png").getImage();
    private final Image openchest = new ImageIcon("resources/openchest.png").getImage();
    private final Image sallyangry = new ImageIcon("resources/sallyangry.png").getImage();

    //LAYOUT
    private JPanel surprise;
    private JLabel sally;
    private JLabel title;
    private JLabel warning;
    private JLabel bg;
    private JLabel skip;
    private JLabel card1;
    private JLabel card1opened;
    private JLabel card2;
    private JLabel card2opened;
    private JLabel card3;
    private JLabel card3opened;

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
        surprise = new JPanel();
        sally = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(sallyangry,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
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

        card1opened = new JLabel() {
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

        card2opened = new JLabel() {
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

        card3opened = new JLabel() {
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

        //SURPRISE
        surprise.setLayout(null);
        surprise.setSize(1162, 648);
        surprise.setVisible(false);
        add(surprise);

        //SALLY
        sally.setBounds(0, 0, 1162, 648);
        surprise.add(sally);

        //TITLE
        title.setBounds(0, 0, this.getWidth(), 60);
        title.setFont(new Font("Monospace", Font.BOLD, 35));
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

        //CARD 1 OPENED
        card1opened.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        card1opened.setBounds(space, space*2, height, width);
        card1opened.setVisible(false);
        add(card1opened);

        //CARD 1
        card1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        card1.setBounds(space, space*2, height, width);
        card1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Are you sure want to open this chest?", "CHEST 1", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHANGE LABEL
                    card1.setVisible(false);
                    card1opened.setVisible(true);

                    //RANDOM
                    int random = (int) (Math.random() * 2);
                    if (random == 0) {
                        JOptionPane.showMessageDialog(null, "Oops you found nothing");
                    } else {
                        surprise.setVisible(true);
                        for (int i = 0; i < 2; i++) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }
                        surprise.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Sally Angry XD");
                    }

                    //ADD & CHECK COUNTER
                    counteropened += 1;
                    if (counteropened == 3) {
                        body.dispose();
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                card1.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                card1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                card1.setSize(card1.getWidth() + 10, card1.getHeight() + 10);
                card1.setLocation(card1.getX() - 5, card1.getY() - 5);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card1.setBorder(BorderFactory.createLineBorder(Color.white, 2));
                card1.setSize(card1.getWidth() - 10, card1.getHeight() - 10);
                card1.setLocation(card1.getX() + 5, card1.getY() + 5);
            }
        });
        add(card1);

        //CARD 2 LAYER
        card2opened.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        card2opened.setBounds((height + space) + space, space*2, height, width);
        card2opened.setVisible(false);
        add(card2opened);

        //CARD 2
        card2.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        card2.setBounds((height + space) + space, space*2, height, width);
        card2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Are you sure want to open this chest?", "CHEST 2", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHANGE LABEL
                    card2.setVisible(false);
                    card2opened.setVisible(true);

                    //RANDOM
                    int random = (int) (Math.random() * 2);
                    if (random == 0) {
                        JOptionPane.showMessageDialog(null, "Oops you found nothing");
                    } else {
                        surprise.setVisible(true);
                        for (int i = 0; i < 2; i++) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }
                        surprise.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Sally Angry XD");
                    }

                    //ADD & CHECK COUNTER
                    counteropened += 1;
                    if (counteropened == 3) {
                        body.dispose();
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                card2.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                card2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                card2.setSize(card2.getWidth() + 10, card2.getHeight() + 10);
                card2.setLocation(card2.getX() - 5, card2.getY() - 5);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card2.setBorder(BorderFactory.createLineBorder(Color.white, 2));
                card2.setSize(card2.getWidth() - 10, card2.getHeight() - 10);
                card2.setLocation(card2.getX() + 5, card2.getY() + 5);
            }
        });
        add(card2);

        //CARD 3 LAYER
        card3opened.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        card3opened.setBounds((height + space)*2 + space, space*2, height, width);
        card3opened.setVisible(false);
        add(card3opened);

        //CARD 3
        card3.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        card3.setBounds((height + space)*2 + space, space*2, height, width);
        card3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Are you sure want to open this chest?", "CHEST 3", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    //CHANGE LABEL
                    card3.setVisible(false);
                    card3opened.setVisible(true);

                    //RANDOM
                    int random = (int) (Math.random() * 2);
                    if (random == 0) {
                        JOptionPane.showMessageDialog(null, "Oops you found nothing");
                    } else {
                        surprise.setVisible(true);
                        for (int i = 0; i < 2; i++) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }
                        surprise.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Sally Angry XD");
                    }

                    //ADD & CHECK COUNTER
                    counteropened += 1;
                    if (counteropened == 3) {
                        body.dispose();
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                card3.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                card3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                card3.setSize(card3.getWidth() + 10, card3.getHeight() + 10);
                card3.setLocation(card3.getX() - 5, card3.getY() - 5);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                card3.setBorder(BorderFactory.createLineBorder(Color.white, 3));
                card3.setSize(card3.getWidth() - 10, card3.getHeight() - 10);
                card3.setLocation(card3.getX() + 5, card3.getY() + 5);
            }
        });
        add(card3);

        //BACKGROUND
        bg.setBounds(0, 50, this.getWidth(), this.getHeight() - 50);
        add(bg);
    }
}
