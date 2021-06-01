package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Card extends JLabel {
    protected static int twice=1;
    protected static int twicetime=1;
    protected String nama, type, desc;
    protected int level, cost;
    protected int damage, block, draw, energy, weak, strength, heal;
    protected boolean active, dispose, singleuse;
    //dispose untuk torpedo, singleuse untuk heal card

    protected Kapal kapal;
    protected Enemy enemy;
    protected Battle battle;

    private class cardMouseAdapter extends MouseAdapter {
        private final Card card;

        public cardMouseAdapter(Card card) {
            this.card = card;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (kapal.getEnergy()>=cost) {
                activate(kapal, enemy, battle);
                kapal.getCard().add(card);
                battle.getHand().remove(card);
                battle.remove(card);
                System.out.println(battle.getHand().size());
                battle.repaint();
            }
        }
    }

    public Card(String nama, String type, int cost) {
        this.nama = nama;
        this.type = type;
        this.level = 1;
        this.cost = cost;
        this.damage = 0;
        this.block = 0;
        this.draw = 0;
        this.energy = 0;
        this.weak = 0;
        this.strength = 0;
        this.heal = 0;
        this.active=true;
        this.dispose=false;
        this.singleuse=false;
        status();
        addMouseListener(new cardMouseAdapter(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        switch (type) {
            case "Self" -> g.setColor(Color.BLUE);
            case "Enemy" -> g.setColor(Color.GREEN);
            case "Battle" -> g.setColor(Color.MAGENTA);
        }
        g.fillRect(0,0,180,320);
        g.setColor(Color.BLACK);
        g.setFont(FontLoader.loadFont("resources/ReggaeOne-Regular.ttf",20));
        g.drawString(nama,10,20);
        g.drawImage(Assets.energy,140,0,20,20,null);
        g.drawString(String.valueOf(cost),160,20);

        String[] descSplit = desc.split("\n");
        for (int i = 0; i < descSplit.length; i++) {
            g.drawString(descSplit[i],10,60+(i*30));
        }
        super.paintComponent(g);
    }

    public void initForBattle(Kapal kapal, Enemy enemy, Battle battle){
        this.kapal = kapal;
        this.enemy = enemy;
        this.battle = battle;
    }

    //all activation use this
    public void activate(Kapal kapal, Enemy enemy, Battle battle){

    }

    public void finish(Kapal kapal){
        drainEnergy(kapal);
        twice();
        active=false;
    }

    public void reactivate(){
        active=true;
    }

    public void twice(){
        if(twicetime>1){
            twicetime--;
        }
        if (twicetime==1){
            twice=1;
        }
    }

    public void upgrade(){
        if(level<2){
            level++;
            status();
        }
    }

    //untuk forge potion
    public void downgrade(){
        if(level>1){
            level--;
            status();
        }
    }

    public void status(){

    }

    public void drainEnergy(Kapal k){
        k.setEnergy(k.getEnergy()-cost);
    }

    public void restoreEnergy(Kapal k){
        k.setEnergy(k.getEnergy()+energy);
        if (k.getEnergy()>k.getMaxenergy()){
            k.setEnergy(k.getMaxenergy());
        }
    }

    public void attack(Kapal k, Enemy e){
        if (k.getAttack()<0){
            k.setAttack(0);
        }
        int attack = damage + k.getAttack();
        if (attack>e.getBlock()){
            attack -= e.getBlock();
            e.setBlock(0);
        }
        else{
            e.setBlock(e.getBlock()-attack);
            attack=0;
        }
        e.setHealth(e.getHealth()-attack);
    }

    public void restoreHealth(Kapal k){
        k.setHealth(k.getHealth()+heal);
        if (k.getHealth()> k.getMaxhealth()){
            k.setHealth(k.getMaxhealth());
        }
    }

    public boolean isSingleuse() {
        return singleuse;
    }

    public void setSingleuse(boolean singleuse) {
        this.singleuse = singleuse;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDispose() {
        return dispose;
    }

    public void setDispose(boolean dispose) {
        this.dispose = dispose;
    }

    public int getTwice() {
        return twice;
    }

    public void setTwice(int twice) {
        Card.twice = twice;
    }

    public static int getTwicetime() {
        return twicetime;
    }

    public void setTwicetime(int twicetime) {
        Card.twicetime = twicetime;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getWeak() {
        return weak;
    }

    public void setWeak(int weak) {
        this.weak = weak;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }
}
