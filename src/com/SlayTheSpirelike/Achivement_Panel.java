package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Achivement_Panel extends JPanel {
    private Body body ;

    public Achivement_Panel(Body body) {
        this.body = body;
        setLayout(null);
        setSize(body.getWidth(), body.getHeight());
        init();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.mainMenuBackground_old,0,0,body.getWidth(),body.getHeight(),null);
    }

    public void init(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(20,20,1122,608);
        panel.setBackground(new Color(228, 233, 237, 100));
        panel.setOpaque(true);
        add(panel);

        //judul
        JLabel label = new JLabel() {
        };
        label.setBounds(10,10,1100,50);
        label.setText("Achivement");
        label.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
//        label.setBackground(Color.black);
//        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        // garis
        JLabel garis = new JLabel(){
        };
        garis.setBounds(panel.getWidth()/2-5,70,10,480);
        garis.setOpaque(true);
        garis.setBackground(Color.black);
        panel.add(garis);

        //achivement 1
        JLabel label1 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                if (!Unlockables.get(Unlockables.achivementList.get(0).getName())){
                    g.setColor(Color.gray);
                    g.fillRect(0,0,490,90);
                }
                g.setColor(Color.black);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
                g.drawString(Unlockables.achivementList.get(0).getName(),20,30);
                g.setFont(new Font("monospace",Font.ITALIC,15));
                g.drawString(Unlockables.achivementList.get(0).getDesc(),20,50);
                super.paintComponent(g);
            }
        };
        label1.setBounds(30,70,490,90);
        panel.add(label1);


        //achivement 2
        JLabel label2 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                if (!Unlockables.get(Unlockables.achivementList.get(1).getName())){
                    g.setColor(Color.gray);
                    g.fillRect(0,0,490,90);
                }
                g.setColor(Color.black);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
                g.drawString(Unlockables.achivementList.get(1).getName(),20,30);
                g.setFont(new Font("monospace",Font.ITALIC,15));
                g.drawString(Unlockables.achivementList.get(1).getDesc(),20,50);
                super.paintComponent(g);
            }
        };
        label2.setBounds(30,200,490,90);
        panel.add(label2);

        //achivement 3
        JLabel label3 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                if (!Unlockables.get(Unlockables.achivementList.get(2).getName())){
                    g.setColor(Color.gray);
                    g.fillRect(0,0,490,90);
                }
                g.setColor(Color.black);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
                g.drawString(Unlockables.achivementList.get(2).getName(),20,30);
                g.setFont(new Font("monospace",Font.ITALIC,15));
                g.drawString(Unlockables.achivementList.get(2).getDesc(),20,50);
                super.paintComponent(g);
            }
        };
        label3.setBounds(30,330,490,90);
        panel.add(label3);

        //achivement 4
        JLabel label4 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                if (!Unlockables.get(Unlockables.achivementList.get(3).getName())){
                    g.setColor(Color.gray);
                    g.fillRect(0,0,490,90);
                }
                g.setColor(Color.black);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
                g.drawString(Unlockables.achivementList.get(3).getName(),20,30);
                g.setFont(new Font("monospace",Font.ITALIC,15));
                g.drawString(Unlockables.achivementList.get(3).getDesc(),20,50);
                super.paintComponent(g);
            }
        };
        label4.setBounds(30,460,490,90);
        panel.add(label4);

        //achivement 5
        JLabel label5 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                if (!Unlockables.get(Unlockables.achivementList.get(4).getName())){
                    g.setColor(Color.gray);
                    g.fillRect(0,0,490,90);
                }
                g.setColor(Color.black);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
                g.drawString(Unlockables.achivementList.get(4).getName(),20,30);
                g.setFont(new Font("monospace",Font.ITALIC,15));
                g.drawString(Unlockables.achivementList.get(4).getDesc(),20,50);
                super.paintComponent(g);
            }
        };
        label5.setBounds(panel.getWidth()/2+40,70,490,90);
        panel.add(label5);

        //achivement 6
        JLabel label6 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                if (!Unlockables.get(Unlockables.achivementList.get(5).getName())){
                    g.setColor(Color.gray);
                    g.fillRect(0,0,490,90);
                }
                g.setColor(Color.black);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
                g.drawString(Unlockables.achivementList.get(5).getName(),20,30);
                g.setFont(new Font("monospace",Font.ITALIC,15));
                g.drawString(Unlockables.achivementList.get(5).getDesc(),20,50);
                super.paintComponent(g);
            }
        };
        label6.setBounds(panel.getWidth()/2+40,200,490,90);
        panel.add(label6);

        //achivement 7
        JLabel label7 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                if (!Unlockables.get(Unlockables.achivementList.get(6).getName())){
                    g.setColor(Color.gray);
                    g.fillRect(0,0,490,90);
                }
                g.setColor(Color.black);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
                g.drawString(Unlockables.achivementList.get(6).getName(),20,30);
                g.setFont(new Font("monospace",Font.ITALIC,15));
                g.drawString(Unlockables.achivementList.get(6).getDesc(),20,50);
                super.paintComponent(g);
            }
        };
        label7.setBounds(panel.getWidth()/2+40,330,490,90);
        panel.add(label7);

        //achivement 8
        JLabel label8 = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                if (!Unlockables.get(Unlockables.achivementList.get(7).getName())){
                    g.setColor(Color.gray);
                    g.fillRect(0,0,490,90);
                }
                g.setColor(Color.black);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
                g.drawString(Unlockables.achivementList.get(7).getName(),20,30);
                g.setFont(new Font("monospace",Font.ITALIC,15));
                g.drawString(Unlockables.achivementList.get(7).getDesc(),20,50);
                super.paintComponent(g);
            }
        };
        label8.setBounds(panel.getWidth()/2+40,460,490,90);
        panel.add(label8);

        //Exit
        JLabel exit = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.plank1,0,0,100,40,null);
                g.setColor(Color.white);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
                g.drawString("Back",20,30);
                super.paintComponent(g);
            }
        };
        exit.setBounds(panel.getWidth()/2+450,580,100,40);
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                body.setPanel(new MainMenu(body));
                super.mouseClicked(e);
            }
        });
        add(exit,0);

    }
}
