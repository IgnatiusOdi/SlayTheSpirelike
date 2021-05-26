package com.SlayTheSpirelike;

public abstract class Card {
    protected String nama, type, desc;
    protected int level, cost;
    protected int damage, block, draw, energy, weak, strength;

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
        status();
    }

    public void activate(Kapal k, Enemy e){

    }

    public void activate(Kapal k){

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
}
