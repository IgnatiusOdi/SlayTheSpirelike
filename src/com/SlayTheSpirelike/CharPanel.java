package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CharPanel extends JPanel {

    private final JLabel next,
                    tanker_desc, warship_desc, airship_desc,
                    tanker_icon, warship_icon, airship_icon,
                    selectWarning;
    private Body body;

    private int selected = -1;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.mainMenuBackground_old,0,0,body.getWidth(),body.getHeight(),null);

//        final int   x=20,
//                    y=100,
//                    width=300,
//                    height=100;

        g.setColor(new Color(255, 255,255, 127));
    }

    public CharPanel(Body body, LayoutManager layout) {
        super(layout);
        this.body = body;
        setSize(1060,600);

        this.tanker_icon = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   ICON_WIDTH =300,
                            ICON_HEIGHT =100;
                if (selected==0){
                    g.setColor(new Color(255, 150,150, 127));
                } else {
                    g.setColor(new Color(255, 255,255, 127));
                }
                g.fillRect(0,0, ICON_WIDTH, ICON_HEIGHT);
                g.drawImage(Assets.tanker, 0,0, ICON_WIDTH, ICON_HEIGHT,null);
                super.paintComponent(g);
            }
        };
        tanker_icon.setBounds(20,100,300,100);
        tanker_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                tanker_desc.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                tanker_desc.setVisible(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                selected = 0;
                tanker_icon.repaint();
                warship_icon.repaint();
                airship_icon.repaint();
            }
        });
        add(tanker_icon);

        this.tanker_desc = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   X=10,
                            Y=20,
                            SPACE_Y = 20;
                g.setColor(new Color(255, 255,255, 127));
                g.fillRect(0,0, 300,100);
                g.setColor(Color.black);
                g.setFont(new Font("SansSerif",Font.BOLD,20));
                // TODO: 15/05/2021 Tanker Stats
                g.drawString("TANKER SHIP",X,Y);
                g.drawString("Health :",X,Y+SPACE_Y);
                g.drawString("Energy :",X,Y+2*SPACE_Y);
                super.paintComponent(g);
            }
        };
        tanker_desc.setBounds(20,200,300,100);
        tanker_desc.setVisible(false);
        add(tanker_desc);

        this.warship_icon = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   ICON_WIDTH =300,
                            ICON_HEIGHT =100;
                if (selected==1){
                    g.setColor(new Color(255, 150,150, 127));
                } else {
                    g.setColor(new Color(255, 255,255, 127));
                }
                g.fillRect(0,0, ICON_WIDTH,ICON_HEIGHT);
                g.drawImage(Assets.warship, 0,0, ICON_WIDTH,ICON_HEIGHT,null);
                super.paintComponent(g);
            }
        };
        warship_icon.setBounds(20+350,100,300,100);
        warship_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                warship_desc.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                warship_desc.setVisible(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                selected = 1;
                tanker_icon.repaint();
                warship_icon.repaint();
                airship_icon.repaint();
            }
        });
        add(warship_icon);

        this.warship_desc = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   X=10,
                            Y=20,
                            SPACE_Y = 20;
                g.setColor(new Color(255, 255,255, 127));
                g.fillRect(0,0, 300,100);
                g.setColor(Color.black);
                g.setFont(new Font("SansSerif",Font.BOLD,20));
                // TODO: 15/05/2021 Warship stats
                g.drawString("WARSHIP",X,Y);
                g.drawString("Health :",X,Y+SPACE_Y);
                g.drawString("Energy :",X,Y+2*SPACE_Y);
                super.paintComponent(g);
            }
        };
        warship_desc.setBounds(20+350,200,300,100);
        warship_desc.setVisible(false);
        add(warship_desc);

        this.airship_icon = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   ICON_WIDTH =300,
                            ICON_HEIGHT =100;
                if (selected==2) {
                    g.setColor(new Color(255, 150,150, 127));
                }  else {
                    g.setColor(new Color(255, 255,255, 127));
                }
                g.fillRect(0,0, ICON_WIDTH,ICON_HEIGHT);
                g.drawImage(Assets.carrier, 0,0, ICON_WIDTH,ICON_HEIGHT,null);
                super.paintComponent(g);
            }
        };
        airship_icon.setBounds(20+2*350,100,300,100);
        airship_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                airship_desc.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                airship_desc.setVisible(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                selected=2;
                tanker_icon.repaint();
                warship_icon.repaint();
                airship_icon.repaint();
            }
        });
        add(airship_icon);

        this.airship_desc = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   X=10,
                            Y=20,
                            SPACE_Y = 20;
                g.setColor(new Color(255, 255,255, 127));
                g.fillRect(0,0, 300,100);
                g.setColor(Color.black);
                g.setFont(new Font("SansSerif",Font.BOLD,20));
                // TODO: 15/05/2021 Airship stats
                g.drawString("AIRSHIP CARRIER",X,Y);
                g.drawString("Health :",X,Y+SPACE_Y);
                g.drawString("Energy :",X,Y+2*SPACE_Y);
                super.paintComponent(g);
            }
        };
        airship_desc.setBounds(20+2*350,200,300,100);
        airship_desc.setVisible(false);
        add(airship_desc);

        this.selectWarning = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.red);
                g.setFont(new Font("SansSerif",Font.BOLD,30));
                g.drawString("Please Select a ship",0,40);
            }
        };
        selectWarning.setBounds(body.getWidth()/2-(300/2),400,300,100);
        selectWarning.setVisible(false);
        add(selectWarning);

        this.next = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.plank2,0,0,100,44,null);
                g.setColor(Color.black);
                g.setFont(new Font("SansSerif",Font.BOLD,20));
                g.drawString("Next >>",15,30);
                super.paintComponent(g);
            }
        };
        next.setBounds(body.getWidth()/2-120/2,450,120,200);
        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (selected==-1){
                    selectWarning.setVisible(true);
                } else{
                    //TODO: go to map?
                }
            }
        });
        add(next);

    }
}
