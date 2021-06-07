package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public abstract class Potion extends Sprite implements Serializable {
    //type ada 3
    //self: bekerja langsung kepada player
    //enemy: bekerja langsung pada enemy
    //battle: bekerja pada battle
    //special: yang butuh kondisi sendiri
    protected String nama,type,rarity, desc;
    protected boolean active;

    protected Kapal kapal;
    protected Enemy enemy;
    protected Battle battle;
    protected JPanel panel;


    JFrame frame;

    private class PotionMouseAdapter extends MouseAdapter {
        //extend JLabel to override paintComponent
        JLabel descLabel = new JLabel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(255, 255,255, 127));
                g.fillRect(0,0,desc.length()*13,40);
                g.setColor(Color.black);
                g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
                g.drawString(desc,10,25);
            }
        };

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            descLabel.setBounds(x,y+height,desc.length()*13,40);
            ((Potion)e.getSource()).getPanel().add(descLabel);
            ((Potion)e.getSource()).getPanel().repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            ((Potion)e.getSource()).getPanel().remove(descLabel);
            ((Potion)e.getSource()).getPanel().repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            ((Potion)e.getSource()).activate(kapal,enemy,battle);
            kapal.getPotion().remove((Potion) e.getSource());
            ((Potion)e.getSource()).getPanel().remove((Potion)e.getSource());
            ((Potion)e.getSource()).getPanel().remove(descLabel);
            ((Potion)e.getSource()).getPanel().repaint();
        }
    }

    public Potion(String nama, String type, String rarity, String image, String desc) {
        super(image);
        this.nama = nama;
        this.type = type;
        this.active = true;
        this.rarity = rarity;
        this.desc = desc;
        addMouseListener(new PotionMouseAdapter());

        //uncomment to look
//        frame = new JFrame();
//        frame.setBackground(Color.BLUE);
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
    }

    public void reConstruct(){
        addMouseListener(new PotionMouseAdapter());
    }

/*    @Override
    public JLabel getItem() {
        return super.getItem();
    }

    @Override
    public void setItem(JLabel item) {
        super.setItem(item);
    }

    @Override
    public JPanel getPanel(int x, int y, int w, int h) {
        return super.getPanel(x, y, w, h);
    }

    @Override
    public void setPanel(JPanel panel) {
        super.setPanel(panel);
    }*/

    //init before battle
    public void initForBattle(Kapal kapal, Enemy enemy,Battle battle){
        this.panel = battle;
        this.battle = battle;
        this.kapal = kapal;
        this.enemy = enemy;
    }

    public void activate(Kapal kapal){

    }

    //hanya jalan saat active == false dan ketika turn di battle berakhir
    //saat battle end, semua potion yang masih active langsung deactivate tanpa pengecekan active
    public void deactivate(Kapal kapal){

    }

    public void activate(Enemy enemy){

    }

    //hanya jalan saat active == false dan ketika turn di battle berakhir
    //saat battle end, semua potion yang masih active langsung deactivate tanpa pengecekan active
    public void deactivate(Enemy enemy){

    }

    public void activate(Battle battle){

    }

    public void deactivate(Battle battle){

    }

    public void activate(Kapal kapal, Enemy enemy, Battle battle){
        activate(kapal);
        activate(enemy);
        activate(battle);
    }

    public void deactivate(Kapal kapal, Enemy enemy, Battle battle){
        deactivate(kapal);
        deactivate(enemy);
        deactivate(battle);
    }

    //return new copy of the Potion
    public abstract Potion copy();

    public boolean activate(){
        return false;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public JPanel getPanel() {
        return panel;
    }
}
