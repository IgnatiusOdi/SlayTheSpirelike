package com.SlayTheSpirelike;

import com.SlayTheSpirelike.MapItems.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Scanner;

public class Map extends JPanel {
    private final Body body;
    private MapTile[][] mapTiles;
    private final Kapal player;
    private final JLabel up;
    private final JLabel down;
    private final JLabel left;
    private final JLabel right;
    private final int   COL_NUM=8, ROW_NUM=5,
                        MAP_PADDING_X=30, MAP_PADDING_Y=80,
                        MAP_WIDTH=1000, MAP_HEIGHT=500;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.map,0,0,body.getWidth(),body.getHeight(),null);
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",30));

        g.drawImage(Assets.heart,200,20,50,50,null);
        g.drawString(player.getHealth() + "/" + player.getMaxhealth(),270,55);

        g.drawImage(Assets.fuelTank,600,20,50,50,null);
        g.drawString(player.getFuel() + "/" + player.getMaxfuel(),670,55);

        g.drawImage(Assets.coin,800,20,50,50,null);
        g.drawString(String.valueOf(player.getCoin()),870,55);

        g.setColor(Color.red);
        for (int i = 0; i < ROW_NUM+1; i++) {
            g.drawLine(MAP_PADDING_X,MAP_PADDING_Y+(i*(MAP_HEIGHT/ROW_NUM)),MAP_PADDING_X+MAP_WIDTH,MAP_PADDING_Y+(i*(MAP_HEIGHT/ROW_NUM)));
        }
        for (int i = 0; i < COL_NUM+1; i++) {
            g.drawLine(MAP_PADDING_X+(i*(MAP_WIDTH/COL_NUM)),MAP_PADDING_Y,MAP_PADDING_X+(i*(MAP_WIDTH/COL_NUM)),MAP_PADDING_Y+MAP_HEIGHT);
        }
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COL_NUM; j++) {
                final int START_X = MAP_PADDING_X + (j * (MAP_WIDTH / COL_NUM)) + 10;
                final int START_Y = MAP_PADDING_Y + (i * (MAP_HEIGHT / ROW_NUM)) + 10;
                if (i==player.getMapPosY() && j==player.getMapPosX()) {
                    if (player instanceof Tanker){
                        g.drawImage(Assets.tanker, START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20,null);
                    } else if (player instanceof Warship){
                        g.drawImage(Assets.warship, START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20,null);
                    } else if (player instanceof Aircraft){
                        g.drawImage(Assets.carrier, START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20,null);
                    }
                } else if (mapTiles[i][j] instanceof EnemyTile && mapTiles[i][j].isDiscovered() ){
//                    g.setColor(Color.RED);
//                    g.fillRect(START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20);
                    g.drawImage(Assets.enemyTile,START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20,null);
                } else if (mapTiles[i][j] instanceof ShopTile && mapTiles[i][j].isDiscovered()){
//                    g.setColor(Color.blue);
//                    g.fillRect(START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20);
                    g.drawImage(Assets.shopTile,START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20,null);
                } else if (mapTiles[i][j] instanceof FuelTile && mapTiles[i][j].isDiscovered()){
//                    g.setColor(Color.BLACK);
//                    g.fillRect(START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20);
                    g.drawImage(Assets.fuelTile,START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20,null);
                } else if (mapTiles[i][j] instanceof TreasureTile && mapTiles[i][j].isDiscovered()){
//                    g.setColor(Color.MAGENTA);
//                    g.fillRect(START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20);
                    g.drawImage(Assets.treasureTile,START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20,null);
                } else if (mapTiles[i][j] instanceof BossTile){
                    g.setColor(Color.GREEN);
                    g.fillRect(START_X, START_Y,(MAP_WIDTH/COL_NUM)-20,(MAP_HEIGHT/ROW_NUM)-20);
                }
            }
        }
    }

    public Map(Body body, Kapal player) {
        this.body = body;
        this.player = player;
        this.setLayout(null);
        setSize(body.getWidth(), body.getHeight());

        randomizeTile();

        down = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
//                g.setColor(new Color(255, 255,100, 127));
//                g.fillRect(0,0,(MAP_WIDTH/COL_NUM)-10,(MAP_HEIGHT/ROW_NUM)+20);
                g.drawImage(Assets.arrowDown,40,0,40,60,null);
            }
        };
        down.setBounds(MAP_PADDING_X + (player.getMapPosX() * (MAP_WIDTH / COL_NUM)) + 5,MAP_PADDING_Y + ((player.getMapPosY()+1) * (MAP_HEIGHT / ROW_NUM)) - 20,(MAP_WIDTH/COL_NUM)-10, (MAP_HEIGHT/ROW_NUM)+20);
        down.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (player.getFuel()>0) {
                    player.setMapPos(player.getMapPosX(), player.getMapPosY()+1);
                    player.consumeFuel(1);
                    checkTile();
                    paintMoveButton();
                } else {
                    zeroFuel();
                }
            }
        });
        add(down);

        up = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
//                g.setColor(new Color(255, 255,100, 127));
//                g.fillRect(0,0,(MAP_WIDTH/COL_NUM)-10,(MAP_HEIGHT/ROW_NUM)+20);
                g.drawImage(Assets.arrowUp,40,60,40,60,null);
            }
        };
        up.setBounds(MAP_PADDING_X + (player.getMapPosX() * (MAP_WIDTH / COL_NUM)) + 5,MAP_PADDING_Y + ((player.getMapPosY()-1) * (MAP_HEIGHT / ROW_NUM)) + 5,(MAP_WIDTH/COL_NUM)-10, (MAP_HEIGHT/ROW_NUM)+20);
        up.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (player.getFuel()>0) {
                    player.setMapPos(player.getMapPosX(), player.getMapPosY()-1);
                    player.consumeFuel(1);
                    checkTile();
                    paintMoveButton();
                } else {
                    zeroFuel();
                }
            }
        });
        add(up);

        right = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
//                g.setColor(new Color(255, 255,100, 127));
//                g.fillRect(0,0,(MAP_WIDTH/COL_NUM)+30,(MAP_HEIGHT/ROW_NUM)-10);
                g.drawImage(Assets.arrowRight,0,20,60,40,null);
            }
        };
        right.setBounds(MAP_PADDING_X + ((player.getMapPosX()+1) * (MAP_WIDTH / COL_NUM)) -30,MAP_PADDING_Y + (player.getMapPosY() * (MAP_HEIGHT / ROW_NUM))+5,(MAP_WIDTH/COL_NUM)+30,(MAP_HEIGHT/ROW_NUM)-10);
        right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (player.getFuel()>0) {
                    player.setMapPos(player.getMapPosX()+1, player.getMapPosY());
                    player.consumeFuel(1);
                    checkTile();
                    paintMoveButton();
                } else {
                    zeroFuel();
                }
            }
        });
        add(right);

        left = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
//                g.setColor(new Color(255, 255,100, 127));
//                g.fillRect(0,0,(MAP_WIDTH/COL_NUM)+30,(MAP_HEIGHT/ROW_NUM)-10);
                g.drawImage(Assets.arrowLeft,90,20,60,40,null);
            }
        };
        left.setBounds(MAP_PADDING_X + ((player.getMapPosX()-1) * (MAP_WIDTH / COL_NUM)) + 5,MAP_PADDING_Y + (player.getMapPosY() * (MAP_HEIGHT / ROW_NUM)) + 5,(MAP_WIDTH/COL_NUM)+30,(MAP_HEIGHT/ROW_NUM)-10);
        left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (player.getFuel()>0) {
                    player.setMapPos(player.getMapPosX()-1, player.getMapPosY());
                    player.consumeFuel(1);
                    checkTile();
                    paintMoveButton();
                } else {
                    zeroFuel();
                }
            }
        });
        add(left);

        paintMoveButton();

        initCheat();
    }

    private void initCheat(){
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_R,0),"randomize");
        getActionMap().put("randomize",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("randomizer");
                randomizeTile();
                repaint();
                revalidate();
                invalidate();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_T,0),"discover");
        getActionMap().put("discover", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("discover");
                for (int i = 0; i < ROW_NUM; i++) {
                    for (int j = 0; j < COL_NUM; j++) {
                        if (mapTiles[i][j] != null) {
                            mapTiles[i][j].discover();
                        }
                    }
                }
                repaint();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F,0),"maxFuel");
        getActionMap().put("maxFuel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Max Fuel");
                player.setFuel(player.getMaxfuel());
                repaint();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C,0),"infCoin");
        getActionMap().put("infCoin", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Infinite Coin");
                player.setCoin(999999);
                repaint();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_P,0),"addPot");
        getActionMap().put("addPot", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner s = new Scanner(System.in);
                System.out.print("addPot :");
                player.addPotion(Statics.commonPotion.get(s.nextInt()));
                repaint();
            }
        });
    }

    private void zeroFuel(){
        // TODO: 19/05/2021 zerofuel
    }

    private void checkTile(){
        if (mapTiles[player.getMapPosY()][player.getMapPosX()] != null){
            mapTiles[player.getMapPosY()][player.getMapPosX()].enterTile();
            if (!(mapTiles[player.getMapPosY()][player.getMapPosX()] instanceof ShopTile)){
                mapTiles[player.getMapPosY()][player.getMapPosX()] = null;
            }
        }
    }

    private void paintMoveButton(){
        left.setVisible(player.getMapPosX() > 0);
        up.setVisible(player.getMapPosY() > 0);
        right.setVisible(player.getMapPosX() < COL_NUM - 1);
        down.setVisible(player.getMapPosY() < ROW_NUM - 1);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (player.getMapPosY()+i>=0 && player.getMapPosX()+j>=0 && player.getMapPosY()+i<ROW_NUM && player.getMapPosX()+j<COL_NUM && mapTiles[player.getMapPosY()+i][player.getMapPosX()+j] != null) {
                    mapTiles[player.getMapPosY()+i][player.getMapPosX()+j].discover();
                }
            }
        }

        down.setBounds(MAP_PADDING_X + (player.getMapPosX() * (MAP_WIDTH / COL_NUM)) + 5,MAP_PADDING_Y + ((player.getMapPosY()+1) * (MAP_HEIGHT / ROW_NUM)) - 20,(MAP_WIDTH/COL_NUM)-10, (MAP_HEIGHT/ROW_NUM)+20);
        up.setBounds(MAP_PADDING_X + (player.getMapPosX() * (MAP_WIDTH / COL_NUM)) + 5,MAP_PADDING_Y + ((player.getMapPosY()-1) * (MAP_HEIGHT / ROW_NUM)) + 5,(MAP_WIDTH/COL_NUM)-10, (MAP_HEIGHT/ROW_NUM)+20);
        right.setBounds(MAP_PADDING_X + ((player.getMapPosX()+1) * (MAP_WIDTH / COL_NUM)) -30,MAP_PADDING_Y + (player.getMapPosY() * (MAP_HEIGHT / ROW_NUM))+ 5,(MAP_WIDTH/COL_NUM)+30,(MAP_HEIGHT/ROW_NUM)-10);
        left.setBounds(MAP_PADDING_X + ((player.getMapPosX()-1) * (MAP_WIDTH / COL_NUM)) + 5,MAP_PADDING_Y + (player.getMapPosY() * (MAP_HEIGHT / ROW_NUM)) + 5,(MAP_WIDTH/COL_NUM)+30,(MAP_HEIGHT/ROW_NUM)-10);
        repaint();
        revalidate();
        invalidate();
    }

    private void randomizeTile(){
        mapTiles = new MapTile[5][8];
        Random r = new Random();
        int x,y;
        do {
            x = r.nextInt(8);
            y = r.nextInt(5);
        } while (mapTiles[y][x]!=null || (x==0 && y==0));
        mapTiles[y][x] = new BossTile();
        for (int i = 0; i < 2; i++) {
            do {
                x = r.nextInt(8);
                y = r.nextInt(5);
            } while (mapTiles[y][x]!=null || (x==0 && y==0));
            mapTiles[y][x] = new ShopTile(body,this, player);
        }
        for (int i = 0; i < 2; i++) {
            do {
                x = r.nextInt(8);
                y = r.nextInt(5);
            } while (mapTiles[y][x]!=null || (x==0 && y==0));
            mapTiles[y][x] = new FuelTile(player);
        }
        for (int i = 0; i < 2; i++) {
            do {
                x = r.nextInt(8);
                y = r.nextInt(5);
            } while (mapTiles[y][x]!=null || (x==0 && y==0));
            mapTiles[y][x] = new TreasureTile(body,this,player);
        }
        for (int i = 0; i < 10; i++) {
            do {
                x = r.nextInt(8);
                y = r.nextInt(5);
            } while (mapTiles[y][x]!=null || (x==0 && y==0));
            mapTiles[y][x] = new EnemyTile(body,this,player);
        }
    }
}
