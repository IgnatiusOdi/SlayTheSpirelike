package com.SlayTheSpirelike;

public abstract class Card {
    protected static int twice=1;
    protected static int twicetime=1;
    protected String nama, type, desc;
    protected int level, cost;
    protected int damage, block, draw, energy, weak, strength;
    protected boolean active;

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
        this.active=false;
        status();
    }
    //enemy
    public void activate(Kapal kapal, Enemy enemy){

    }
    //self
    public void activate(Kapal kapal){

    }
    //battle
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

    public int getTwice() {
        return twice;
    }

    public void setTwice(int twice) {
        this.twice = twice;
    }

    public static int getTwicetime() {
        return twicetime;
    }

    public void setTwicetime(int twicetime) {
        this.twicetime = twicetime;
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
