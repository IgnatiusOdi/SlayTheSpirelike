package com.SlayTheSpirelike;

import javax.swing.*;

public abstract class Summon {
    //jika ada summon, enemy akan attack summon yang terbaru
    //summon attack setelah player selesai attack, attack random/musuh terdepan

    protected String nama;
    protected int health, maxhealth, attack;
    protected JLabel summon;
    protected JPanel panel;

    JFrame frame;

    public Summon(String nama, int health, int maxhealth, int attack,String image) {
        this.nama = nama;
        this.health = health;
        this.maxhealth = maxhealth;
        this.attack = attack;
        this.summon.setIcon(new ImageIcon(image));
        this.panel = new JPanel();
        this.panel.add(summon);
        this.panel.setSize(50,50);
        this.panel.setOpaque(false);
        //uncomment to look
//        frame = new JFrame();
//        frame.setBackground(Color.BLUE);
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public void setMaxhealth(int maxhealth) {
        this.maxhealth = maxhealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
