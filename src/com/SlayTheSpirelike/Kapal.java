package com.SlayTheSpirelike;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Kapal {
    protected int health, maxhealth,block,attack, fuel, maxfuel, energy, maxenergy, coin, mapPosX, mapPosY;
    protected String nama;
//    public static ArrayList<> card = new ArrayList();
    protected int potionLimit;
    protected ArrayList<Potion> potion;
    protected ArrayList<Relic> relic;
    protected JLabel kapal;
    protected JPanel panel;
    JFrame frame;

    public Kapal(String nama,String image) {
        this.relic = new ArrayList();
        this.potion = new ArrayList();
        this.potionLimit = 5;
        this.nama = nama;
        this.block = 0;
        this.attack = 0;
        this.health = 20;
        this.maxhealth = 20;
        this.fuel = 20;
        this.maxfuel = 20;
        this.energy = 3;
        this.maxenergy = 3;
        this.coin = 0;
        this.mapPosX = 0;
        this.mapPosY = 0;
        this.kapal = new JLabel();
        this.kapal.setIcon(new ImageIcon(image));
        this.panel = new JPanel();
        this.panel.add(kapal);
        this.panel.setSize(50,50);
        this.panel.setOpaque(false);

//                frame = new JFrame();
//        frame.add(panel);
//        frame.pack();
//        frame.setVisible(true);
    }
    //cek eksistensi potion
    public boolean isPotion(String nama){
        boolean exist = false;
        for (Potion pot:potion) {
            if (pot.getNama().equals(nama)){
                exist = true;
            }
        }
        return exist;
    }

    public void obtainPotion(Potion p){
        if (potion.size()<5){
            potion.add(p);
        }
        else{
            //code untuk layar delete potion untuk tambah potion baru
        }
    }

    public int getPotionsize(){
        return potion.size();
    }

    public boolean isAlive(){
        if (health>0){
            return true;
        }
        else return false;
    }

    public Potion usePotion(int i){
        Potion use = potion.get(i);
        potion.remove(i);
        return use;
    }

    public void viewPotion(){
        for (Potion p:potion) {
            System.out.println(p.getNama());
        }
    }

    public void setMapPos(int mapPosX, int mapPosY) {
        this.mapPosX = mapPosX;
        this.mapPosY = mapPosY;
    }

    public int getMapPosX() {
        return mapPosX;
    }

    public int getMapPosY() {
        return mapPosY;
    }

    public void getRelic(Relic r){
        relic.add(r);
    }

    public Relic useRelic(int i){
        return relic.get(i);
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
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

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getMaxfuel() {
        return maxfuel;
    }

    public void setMaxfuel(int maxfuel) {
        this.maxfuel = maxfuel;
    }

    public void consumeFuel(int fuelConsumed){
        this.fuel -= fuelConsumed;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMaxenergy() {
        return maxenergy;
    }

    public void setMaxenergy(int maxenergy) {
        this.maxenergy = maxenergy;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Kapal{" +
                "health=" + health +
                ", maxhealth=" + maxhealth +
                ", block=" + block +
                ", attack=" + attack +
                ", fuel=" + fuel +
                ", maxfuel=" + maxfuel +
                ", energy=" + energy +
                ", maxenergy=" + maxenergy +
                ", coin=" + coin +
                ", nama='" + nama + '\'' +
                ", potionLimit=" + potionLimit +
                ", potion=" + potion +
                '}';
    }
}
