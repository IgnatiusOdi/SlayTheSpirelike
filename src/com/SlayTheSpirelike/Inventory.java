package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Inventory extends JPanel {
    private final Body body;
    private Kapal player;
    private final JPanel returnPanel;
    private JLabel exit, cardButton, relicButton, potionButton;
    private JPanel cardHolder, relicHolder, potionHolder;
    private JScrollPane scroll;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.woodenBG,0,0,body.getWidth(),body.getHeight(),null);

        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",30));
        g.setColor(Color.white);

        g.drawImage(Assets.heart,200,20,50,50,null);
        g.drawString(player.getHealth() + "/" + player.getMaxhealth(),270,55);

        g.drawImage(Assets.fuelTank,600,20,50,50,null);
        g.drawString(player.getFuel() + "/" + player.getMaxfuel(),670,55);

        g.drawImage(Assets.coin,800,20,50,50,null);
        g.drawString(String.valueOf(player.getCoin()),870,55);
    }

    public Inventory(Body body, Kapal player, JPanel returnPanel) {
        this.body = body;
        this.player = player;
        this.returnPanel = returnPanel;
        this.setLayout(null);
        setSize(body.getWidth(), body.getHeight());

        initComponets();
    }

    private void initComponets(){
        exit = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Assets.deck,0,0,40,55,null);
            }
        };
        exit.setBounds(1100,10,40,55);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                body.setPanel(returnPanel);
            }
        });
        add(exit);

        cardButton = new JLabel("Cards"){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.woodenBG,0,0,body.getWidth()/3,50,null);
                super.paintComponent(g);
            }
        };
        cardButton.setBounds(0, 165,body.getWidth()/3,50);
        cardButton.setBorder(BorderFactory.createLineBorder(Color.green,2));
        cardButton.setHorizontalAlignment(SwingConstants.CENTER);
        cardButton.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 30));
        cardButton.setForeground(Color.white);
        cardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cardButton.setBorder(BorderFactory.createLineBorder(Color.green,2));
                relicButton.setBorder(BorderFactory.createLineBorder(Color.red,2));
                potionButton.setBorder(BorderFactory.createLineBorder(Color.red,2));
                scroll.setViewportView(cardHolder);
            }
        });
        add(cardButton);

        relicButton = new JLabel("Relics"){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.woodenBG,0,0,body.getWidth()/3,50,null);
                super.paintComponent(g);
            }
        };
        relicButton.setBounds(body.getWidth()/3, 165,body.getWidth()/3,50);
        relicButton.setBorder(BorderFactory.createLineBorder(Color.red,2));
        relicButton.setHorizontalAlignment(SwingConstants.CENTER);
        relicButton.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 30));
        relicButton.setForeground(Color.white);
        relicButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                scroll.setViewportView(relicHolder);
                cardButton.setBorder(BorderFactory.createLineBorder(Color.red,2));
                relicButton.setBorder(BorderFactory.createLineBorder(Color.green,2));
                potionButton.setBorder(BorderFactory.createLineBorder(Color.red,2));
            }
        });
        add(relicButton);

        potionButton = new JLabel("Potions"){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.woodenBG,0,0,body.getWidth()/3,50,null);
                super.paintComponent(g);
            }
        };
        potionButton.setBounds(2*body.getWidth()/3, 165,body.getWidth()/3,50);
        potionButton.setBorder(BorderFactory.createLineBorder(Color.red,2));
        potionButton.setHorizontalAlignment(SwingConstants.CENTER);
        potionButton.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 30));
        potionButton.setForeground(Color.white);
        potionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cardButton.setBorder(BorderFactory.createLineBorder(Color.red,2));
                relicButton.setBorder(BorderFactory.createLineBorder(Color.red,2));
                potionButton.setBorder(BorderFactory.createLineBorder(Color.green,2));
                scroll.setViewportView(potionHolder);
            }
        });
        add(potionButton);

        cardHolder = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.woodenBG,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        showCards();
        cardHolder.setBounds(0, 0, this.getWidth() - 20, 350);
        cardHolder.setLayout(new FlowLayout(FlowLayout.CENTER));
        cardHolder.setBackground(Color.yellow);
        cardHolder.setOpaque(true);

        relicHolder = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.woodenBG,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        showRelics();
        relicHolder.setBounds(0, 0, this.getWidth() - 20, 350);
        relicHolder.setLayout(new FlowLayout(FlowLayout.CENTER));
        relicHolder.setBackground(Color.yellow);
        relicHolder.setOpaque(true);

        potionHolder = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.woodenBG,0,0, this.getWidth(), this.getHeight(),null);
                super.paintComponent(g);
            }
        };
        showPotions();
        potionHolder.setBounds(0, 0, this.getWidth() - 20, 350);
        potionHolder.setLayout(new FlowLayout(FlowLayout.CENTER));
        potionHolder.setBackground(Color.yellow);
        potionHolder.setOpaque(true);

        scroll = new JScrollPane(cardHolder, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, 215, this.getWidth(), 430);
        scroll.setViewportView(cardHolder);
        add(scroll);
    }

    private void showCards(){
        cardHolder.removeAll();
        int cardheight = 220 * (1 + (player.getCard().size()/5));
        cardHolder.setPreferredSize(new Dimension(this.getWidth() - 20, cardheight));
        ArrayList<JLabel> cards = new ArrayList<>();
        for (int i = 0; i < player.getCard().size(); i++) {
            Card mycard = player.getCard(i);
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
                    g.drawString("Level : " + mycard.getLevel(), this.getWidth()/2, 15);

                    String[] descSplit = mycard.getDesc().split("\n");
                    for (int i = 0; i < descSplit.length; i++) {
                        g.drawString(descSplit[i],10,this.getHeight()/2 + ( i*30));
                    }
                    super.paintComponent(g);
                }
            });
            cards.get(i).setPreferredSize(new Dimension(180, 200));
            cardHolder.add(cards.get(i));
        }
        cardHolder.repaint();
        cardHolder.revalidate();
    }

    private void showRelics() {
        relicHolder.removeAll();
        int relicheight = 155 * (1 + (player.getRelic().size()/5));
        relicHolder.setPreferredSize(new Dimension(this.getWidth() - 20, relicheight));
        ArrayList<JLabel> relics = new ArrayList<>();
        for (int i = 0; i < player.getRelic().size(); i++) {
            Relic myrelic = player.getRelic(i);
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
            relics.get(i).setPreferredSize(new Dimension(180, 200));
            relicHolder.add(relics.get(i));
        }
        relicHolder.repaint();
        relicHolder.revalidate();
    }

    private void showPotions(){
        potionHolder.removeAll();
        int potionHeight = 155 * (1 + (player.getPotion().size()/5));
        potionHolder.setPreferredSize(new Dimension(this.getWidth() - 20, potionHeight));
        ArrayList<JLabel> potions = new ArrayList<>();
        for (int i = 0; i < player.getPotion().size(); i++) {
            Potion mypotion = player.getPotion(i);
            potions.add(new JLabel() {
                @Override
                protected void paintComponent(Graphics g) {
                    g.setColor(Color.blue);
                    g.fillRect(0,0, this.getWidth(), this.getHeight());
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Monospace", Font.BOLD, 15));
                    g.drawString(mypotion.getNama(),10, this.getHeight()/4);

                    String[] descSplit = mypotion.getDesc().split("\n");
                    for (int i = 0; i < descSplit.length; i++) {
                        g.drawString(descSplit[i],10,this.getHeight()/2 + ( i*30));
                    }
                    super.paintComponent(g);
                }
            });
            potions.get(i).setPreferredSize(new Dimension(180, 200));
            potionHolder.add(potions.get(i));
        }
        potionHolder.repaint();
        potionHolder.revalidate();
    }

}
