package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Potion extends Sprite {
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

    private class PotionMouseAdapter extends MouseAdapter{
        private Potion potion;
        private JPanel panel;

        public PotionMouseAdapter(Potion potion) {
            this.potion = potion;
        }

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
            panel.add(descLabel);
            panel.repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            panel.remove(descLabel);
            panel.repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            potion.activate(kapal,enemy,battle);
            kapal.getPotion().remove(potion);
            panel.remove(potion);
            panel.remove(descLabel);
            panel.repaint();
        }

        public void setPanel(JPanel panel) {
            this.panel = panel;
        }
    }
    PotionMouseAdapter pma = new PotionMouseAdapter(this);

    public Potion(String nama, String type, String rarity, String image, String desc) {
        super(ImageLoader.LoadImage(image));
        this.nama = nama;
        this.type = type;
        this.active = true;
        this.rarity = rarity;
        this.desc = desc;
        addMouseListener(pma);

        //uncomment to look
//        frame = new JFrame();
//        frame.setBackground(Color.BLUE);
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
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
        pma.setPanel(battle);
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
}
