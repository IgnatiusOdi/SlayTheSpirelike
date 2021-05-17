package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;

public abstract class Potion {
    //type ada 3
    //self: bekerja langsung kepada player
    //enemy: bekerja langsung pada enemy
    //battle: bekerja pada battle
    //special: yang butuh kondisi sendiri
    protected String nama,type,rarity, desc;
    protected boolean active;
    protected JLabel potion;
    protected JPanel panel;

    JFrame frame;

    public Potion(String nama, String type, String rarity, String image, String desc) {
        this.nama = nama;
        this.type = type;
        this.active = true;
        this.rarity = rarity;
        this.desc = desc;
        this.potion = new JLabel();
        this.potion.setText(nama);
        this.potion.setIcon(new ImageIcon(image));
        this.potion.setVerticalTextPosition(JLabel.BOTTOM);
        this.potion.setHorizontalTextPosition(JLabel.CENTER);
        this.panel = new JPanel();
        this.panel.add(potion);
        this.panel.setSize(50,50);
        this.panel.setOpaque(false);
        //uncomment to look
//        frame = new JFrame();
//        frame.setBackground(Color.BLUE);
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
    }

    public JPanel getPanel(int x, int y) {
        panel.setLocation(x,y);
        return panel;
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
