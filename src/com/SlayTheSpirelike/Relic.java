package com.SlayTheSpirelike;

import com.SlayTheSpirelike.ShopDivisions.Buy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    protected JPanel panel;

    JFrame frame;

    private class RelicMouseAdapter extends MouseAdapter {
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
            ((Relic)e.getSource()).getPanel().add(descLabel);
            ((Relic)e.getSource()).getPanel().repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            ((Relic)e.getSource()).getPanel().remove(descLabel);
            ((Relic)e.getSource()).getPanel().repaint();
        }
    }

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
        addMouseListener(new RelicMouseAdapter());
        //uncomment to look
//        frame = new JFrame();
//        frame.setBackground(Color.BLUE);
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
    }

    public void reConstruct(){
        addMouseListener(new RelicMouseAdapter());
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

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }
}
