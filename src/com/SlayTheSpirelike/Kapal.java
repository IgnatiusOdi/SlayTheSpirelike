package com.SlayTheSpirelike;

import java.util.ArrayList;

public abstract class Kapal {
    protected int health, maxhealth,block,attack, fuel, maxfuel, energy, maxenergy, coin;
    protected String nama;
//    public static ArrayList<> card = new ArrayList();
    protected int potionLimit;
    protected ArrayList<Potion> potion;
//    public static ArrayList<> artifact = new ArrayList();


    public Kapal(String nama) {
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
    }

    public void getPotion(Potion p){
        if (potion.size()<=5){
            potion.add(p);
        }
        else{
            //code untuk layar delete potion untuk tambah potion baru
        }
    }

    public Potion usePotion(int i){
        Potion use = potion.get(i);
        potion.remove(i);
        return use;
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
