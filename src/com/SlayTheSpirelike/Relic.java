package com.SlayTheSpirelike;

import com.SlayTheSpirelike.ShopDivisions.Buy;

import javax.swing.*;
import java.io.Serializable;

public abstract class Relic extends Sprite implements Serializable {
    //condition
    //- Passive
//- Start Turn
//- End Turn
//- Start Battle
//- End Battle
//- Death
//- Pick Up
    //- Damaged
//- Special
    // - One Time
    protected String nama,rarity,condition,desc;
    protected boolean active;

    JFrame frame;

    public Relic(String nama, String rarity, String condition, String image, String desc) {
        super(image);
//        this.item.setText(nama);
//        this.item.setVerticalTextPosition(JLabel.BOTTOM);
//        this.item.setHorizontalTextPosition(JLabel.CENTER);
        this.nama = nama;
        this.rarity = rarity;
        this.active = true;
        this.condition = condition;
        this.desc = desc;
        //uncomment to look
//        frame = new JFrame();
//        frame.setBackground(Color.BLUE);
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
    }

    //relic yang tidak memiliki override cara kerjanya adalah, ketika kondisi tercapai, kalau ada relic ini, activate kode yang tempat itu
    public void activate(Kapal kapal){

    }

    //deactivate relic adalah untuk reset relic pada state sebelum dipakai untuk apa-apa
    public void deactivate(Kapal kapal){
        active = true;
    }

    public void activate(Enemy enemy){

    }

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

    //untuk membership card relic
    public void activate(Buy buy){

    }

    //untuk membership card relic
    public void deactivate(Buy buy){

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

    //untuk cheat, return new copy of the Relic
    public abstract Relic copy();

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
