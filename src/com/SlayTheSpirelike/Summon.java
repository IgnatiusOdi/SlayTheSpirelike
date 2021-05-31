package com.SlayTheSpirelike;

import javax.swing.*;

public abstract class Summon extends Sprite{
    //jika ada summon, enemy akan attack summon yang terbaru
    //summon attack setelah player selesai attack, attack random/musuh terdepan

    protected String nama;
    protected int health, maxhealth, attack;

    JFrame frame;

    public Summon(String nama, int health, int maxhealth, int attack,String image) {
        super(ImageLoader.LoadImage(image));
        this.nama = nama;
        this.health = health;
        this.maxhealth = maxhealth;
        this.attack = attack;
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
