package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CharSelect extends JPanel {

    private JTextField nameField;
    private final JLabel saveNameLabel,next,
                    tanker_desc, warship_desc, airship_desc,
                    tanker_icon, warship_icon, airship_icon,
                    warning;
    private final int   ICON_X=80,
                        ICON_Y=100,
                        width=300,
                        height=100;
    private boolean ship2unlocked, ship3unlocked;
    private int selected = -1;
    private Body body;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.mainMenuBackground_old,0,0,body.getWidth(),body.getHeight(),null);
    }

    public CharSelect(Body body) {
        this.body = body;
        setSize(body.getWidth(), body.getHeight());
        setLayout(null);
                                                                                                                        //unlock Ship Here
        this.ship2unlocked = false;
        this.ship3unlocked = false;

        Color whiteBG = new Color(255, 255,255, 127);
        Color redSelected = new Color(255, 150,150, 127);
        Color grayDisabled = new Color(109, 109, 109, 127);

        saveNameLabel = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(whiteBG);
                g.fillRect(0,0,200,50);
                super.paintComponent(g);
            }
        };
        saveNameLabel.setBounds(200,50,300,50);
        saveNameLabel.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",30));
        saveNameLabel.setText("Name :");
        add(saveNameLabel);

        nameField = new JTextField(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.plank3,0,0,500,50,null);
                g.drawString(nameField.getText(),20,40);
//                super.paintComponent(g);
            }
        };
        nameField.setBounds(400,50,500,50);
        nameField.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",30));
        nameField.setBorder(null);
        nameField.setOpaque(false);
        add(nameField);

        this.tanker_icon = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   ICON_WIDTH =300,
                            ICON_HEIGHT =100;
                if (selected==0){
                    g.setColor(redSelected);
                } else {
                    g.setColor(whiteBG);
                }
                g.fillRect(0,0, ICON_WIDTH, ICON_HEIGHT);
                g.drawImage(Assets.tanker, 0,0, ICON_WIDTH, ICON_HEIGHT,null);
                super.paintComponent(g);
            }
        };
        tanker_icon.setBounds(ICON_X,130,300,100);
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
                g.setColor(whiteBG);
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
        tanker_desc.setBounds(ICON_X,230,300,100);
        tanker_desc.setVisible(false);
        add(tanker_desc);

        this.warship_icon = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   ICON_WIDTH =300,
                            ICON_HEIGHT =100;
                if (selected==1){
                    g.setColor(redSelected);
                } else {
                    g.setColor(whiteBG);
                }
                g.fillRect(0,0, ICON_WIDTH,ICON_HEIGHT);
                g.drawImage(Assets.warship, 0,0, ICON_WIDTH,ICON_HEIGHT,null);
                if (!ship2unlocked){
                    g.setColor(grayDisabled);
                    g.fillRect(0,0, ICON_WIDTH,ICON_HEIGHT);
                }
                super.paintComponent(g);
            }
        };
        warship_icon.setBounds(ICON_X+350,130,300,100);
        warship_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (ship2unlocked)
                    warship_desc.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (ship2unlocked)
                    warship_desc.setVisible(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (ship2unlocked){
                    selected = 1;
                    tanker_icon.repaint();
                    warship_icon.repaint();
                    airship_icon.repaint();
                }
            }
        });
        add(warship_icon);

        this.warship_desc = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   X=10,
                            Y=20,
                            SPACE_Y = 20;
                g.setColor(whiteBG);
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
        warship_desc.setBounds(ICON_X+350,230,300,100);
        warship_desc.setVisible(false);
        add(warship_desc);

        this.airship_icon = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   ICON_WIDTH =300,
                            ICON_HEIGHT =100;
                if (selected==2) {
                    g.setColor(redSelected);
                }  else {
                    g.setColor(whiteBG);
                }
                g.fillRect(0,0, ICON_WIDTH,ICON_HEIGHT);
                g.drawImage(Assets.carrier, 0,0, ICON_WIDTH,ICON_HEIGHT,null);
                if (!ship3unlocked) {
                    g.setColor(grayDisabled);
                    g.fillRect(0,0, ICON_WIDTH,ICON_HEIGHT);
                }
                super.paintComponent(g);
            }
        };
        airship_icon.setBounds(ICON_X+2*350,130,300,100);
        airship_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (ship3unlocked)
                    airship_desc.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (ship3unlocked)
                    airship_desc.setVisible(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (ship3unlocked){
                    selected=2;
                    tanker_icon.repaint();
                    warship_icon.repaint();
                    airship_icon.repaint();
                }
            }
        });
        add(airship_icon);

        this.airship_desc = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                final int   X=10,
                            Y=20,
                            SPACE_Y = 20;
                g.setColor(whiteBG);
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
        airship_desc.setBounds(ICON_X+2*350,230,300,100);
        airship_desc.setVisible(false);
        add(airship_desc);

        this.warning = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Color.red);
//                g.setFont(new Font("SansSerif",Font.BOLD,30));
//                g.drawString("Please Select a ship",0,40);
                super.paintComponent(g);
            }
        };
        warning.setBounds(body.getWidth()/2-(300/2),400,300,50);
        warning.setFont(new Font("SansSerif",Font.BOLD,30));
        warning.setForeground(Color.red);
        warning.setVisible(false);
        add(warning);

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
                    warning.setText("Please Select a ship");
                    warning.setVisible(true);
                } else if (nameField.getText().equals("")){
                    warning.setText("Please Input a name");
                    warning.setVisible(true);
                } else {
                    //init player
                    Kapal player;
                    if (selected==0){
                        player = new Tanker(nameField.getText());
                    } else if (selected==1){
                        player = new Warship(nameField.getText());
                    } else {
                        player = new Aircraft(nameField.getText());
                    }
                    body.setPanel(new Map(body,player));
                }
            }
        });
        add(next);

    }
}
