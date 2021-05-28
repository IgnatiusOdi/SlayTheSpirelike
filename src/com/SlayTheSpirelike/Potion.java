package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;

public abstract class Potion extends Sprite {
    //type ada 3
    //self: bekerja langsung kepada player
    //enemy: bekerja langsung pada enemy
    //battle: bekerja pada battle
    //special: yang butuh kondisi sendiri
    protected String nama,type,rarity, desc;
    protected boolean active;

    JFrame frame;

    public Potion(String nama, String type, String rarity, String image, String desc) {
        super(image);
        this.item.setText(nama);
        this.item.setVerticalTextPosition(JLabel.BOTTOM);
        this.item.setHorizontalTextPosition(JLabel.CENTER);
        this.nama = nama;
        this.type = type;
        this.active = true;
        this.rarity = rarity;
        this.desc = desc;

        //uncomment to look
//        frame = new JFrame();
//        frame.setBackground(Color.BLUE);
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
    }

    @Override
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
