package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;

public class Relic {
    protected String nama,rarity,condition;
    protected boolean active;
    protected JLabel relic;
    protected JPanel panel;

    JFrame frame;

    public Relic(String nama, String rarity, String condition, String image) {
        this.nama = nama;
        this.rarity = rarity;
        this.active = true;
        this.condition = condition;
        this.relic = new JLabel();
        this.relic.setText(nama);
        this.relic.setIcon(new ImageIcon(image));
        this.relic.setVerticalTextPosition(JLabel.BOTTOM);
        this.relic.setHorizontalTextPosition(JLabel.CENTER);
        this.panel = new JPanel();
        this.panel.add(relic);
        this.panel.setSize(50,50);
        this.panel.setOpaque(false);
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

    public void deactivate(Kapal kapal){

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
