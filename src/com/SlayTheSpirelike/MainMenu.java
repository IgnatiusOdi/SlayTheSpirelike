package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainMenu extends JPanel {
    private JButton button;
    private JLabel label;
    private JLabel bg;
    private Body body;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.mainMenuBackground_old,0,0,body.getWidth(),body.getHeight(),null);

        g.setColor(Color.red);
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",30));
        g.drawString("Main Menu", body.getWidth() / 2 - 80, 35);
    }

    public MainMenu(Body body, LayoutManager layout) {
        super(layout);
        this.body = body;
        setSize(body.getWidth(), body.getHeight());

        this.label = new JLabel(){
            boolean hovered = false;
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.plank1,0,0,200,50,null);
                g.setColor(Color.red);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
//                g.setFont(new Font("Monospace", Font.BOLD, 30));
                g.drawString("New Game",20,35);
                /*if (hovered) {
                    g.drawImage(Assets.plank1,10,0,null);
                    g.setColor(Color.red);
                    g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
                    g.drawString("New Game",0,0);
                } else {
                    g.drawImage(Assets.plank1,0,0,null);
                    g.setColor(Color.red);
                    g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
                    g.drawString("New Game",0,0);
                }*/
                super.paintComponent(g);
            }
        };
        label.setBounds(body.getWidth()/2 -100, 100,200,50);
//        label.setHorizontalTextPosition(JLabel.CENTER);
//        label.setVerticalTextPosition(JLabel.CENTER);
//        label.setForeground(Color.red);
//        label.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
//        label.setText("New Game");
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                body.setPanel(new CharPanel(body, layout));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                label.setLocation(label.getX()+10, label.getY());
                System.out.println("aaaaa");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                label.setLocation(label.getX()-10, label.getY());
            }
        });

        label.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }

        });
        add(label);

//        this.button = new JButton();
//        button.setBounds(body.getWidth()/2 -100, 100,200,50);
//        button.setHorizontalTextPosition(JButton.CENTER);
//        button.setVerticalTextPosition(JButton.CENTER);
//        button.setIcon(new ImageIcon(Assets.plank1));
//        button.setText("New Game");
//        button.addActionListener((e) -> body.setPanel(new CharPanel(body, layout)));
//        add(button);
    }
}
