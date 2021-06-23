package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JPanel {
    private JLabel newGame, loadGame, Achivement, exit;
    private Body body;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.mainMenuBackground_old,0,0,body.getWidth(),body.getHeight(),null);

        g.drawImage(Assets.board,body.getWidth() / 2 - 200, 0,400,150,null);
        g.setColor(Color.white);
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",30));
        g.drawString("Slay D Ships", body.getWidth() / 2 - 100, 115);
    }

    public MainMenu(Body body) {
        this.body = body;
        setSize(body.getWidth(), body.getHeight());
        setLayout(null);

        this.newGame = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.plank1,0,0,200,50,null);
                g.setColor(Color.white);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
//                g.setFont(new Font("Monospace", Font.BOLD, 30));
                g.drawString("New Game",20,35);
                super.paintComponent(g);
            }
        };
        newGame.setBounds(body.getWidth()/2 -100, 200,200,50);
        newGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                body.setPanel(new CharSelect(body));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                newGame.setLocation(newGame.getX()+10, newGame.getY());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                newGame.setLocation(newGame.getX()-10, newGame.getY());
            }
        });
        add(newGame);

        this.loadGame = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.plank1,0,0,200,50,null);
                g.setColor(Color.white);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
                g.drawString("Load Game",20,35);
                super.paintComponent(g);
            }
        };
        loadGame.setBounds(body.getWidth()/2 -100, 260,200,50);
        loadGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Map m = new Map(body,new Kapal("TEMP","TEMP") {}, 0);
                new LoadGame(m);
                body.setPanel(m);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                loadGame.setLocation(loadGame.getX()+10, loadGame.getY());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loadGame.setLocation(loadGame.getX()-10, loadGame.getY());
            }
        });
        add(loadGame);

        this.Achivement = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.plank1,0,0,200,50,null);
                g.setColor(Color.white);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
                g.drawString("Achivement",20,35);
                super.paintComponent(g);
            }
        };
        Achivement.setBounds(body.getWidth()/2 -100, 320,200,50);
        Achivement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                body.setPanel(new Achivement_Panel(body));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Achivement.setLocation(Achivement.getX()+10, Achivement.getY());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Achivement.setLocation(Achivement.getX()-10, Achivement.getY());
            }
        });
        add(Achivement);

        this.exit = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(Assets.plank1,0,0,200,50,null);
                g.setColor(Color.white);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",25));
                g.drawString("Exit",20,35);
                super.paintComponent(g);
            }
        };
        exit.setBounds(body.getWidth()/2 -100, 380,200,50);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                exit.setLocation(exit.getX()+10, exit.getY());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                exit.setLocation(exit.getX()-10, exit.getY());
            }
        });
        add(exit);


    }
}
