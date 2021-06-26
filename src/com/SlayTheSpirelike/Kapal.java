package com.SlayTheSpirelike;

import com.SlayTheSpirelike.Cards.TorpedoCard;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Kapal extends Sprite implements Serializable {
    protected int health, maxhealth,block,attack, fuel, maxfuel, energy, maxenergy, coin, mapPosX, mapPosY, weak;
    protected String nama;
    protected ArrayList<Card> card;
    protected int potionLimit;
    protected ArrayList<Potion> potion;
    protected ArrayList<Relic> relic;
    protected ArrayList<Summon> summon;
//    protected JLabel kapal;
//    protected JPanel panel;
//    JFrame frame;

    public Kapal(String nama,String image) {
        super(image);
        this.relic = new ArrayList<>();
        this.card = new ArrayList<>();
        this.potion = new ArrayList<>();
        this.summon = new ArrayList<>();
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
        this.weak = 0;
    }

    public void reConstruct(){
        for (Card c : card) {
            c.reConstruct();
        }
        for (Potion p : potion) {
            p.reConstruct();
        }
        for (Relic r : relic) {
            r.reConstruct();
        }
    }

    public void setTwice(int t){
        if(card.size()>0){
            card.get(0).setTwice(t);
        }
        else{
            card.add(new TorpedoCard());
            card.get(0).setTwice(t);
            card.remove(0);
        }
    }

    public void addCard(Card c){
        card.add(c);
    }

    public void upgradeCard(){
        for (Card c:card) {
            c.upgrade();
        }
    }

    public void downgradeCard(){
        for (Card c:card) {
            c.downgrade();
        }
    }

    public void reactivateCard(){
        for (Card c:card) {
            c.reactivate();
        }
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

    public int summonSize(){
        return summon.size();
    }

    public void summon(Summon summon){
        this.summon.add(summon);
    }

    //setelah battle, jalan ini untuk desummon
    public void desummon(){
        summon.clear();
    }

    public void destroySummon(){
        if (summon.size()>0){
            summon.remove(summon.size()-1);
        }
    }

    public void destroySummon(int attack){
        while(summon.size()>0&&attack>0){
            if(summon.get(summon.size()-1).getHealth()<attack){
                attack -= summon.get(summonSize()-1).getHealth();
                summon.remove(summon.size()-1);
            }
            else{
                summon.get(summonSize()-1).setHealth(summon.get(summonSize()-1).getHealth()-attack);
                attack=0;
            }
        }
    }

    public void summonAttack(Enemy enemy){
        for (Summon s:summon) {
            enemy.setHealth(enemy.getHealth()-s.getAttack());

        }
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

    public void addPotion(Potion p){
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

    public int getPotionLimit() {
        return potionLimit;
    }

    public void setPotionLimit(int potionLimit) {
        this.potionLimit = potionLimit;
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

    public void addRelic(Relic r){
        relic.add(r);
    }

    //waktu battle
    public void activateRelic(String condition, Enemy enemy, Battle battle){
        for (Relic r:relic) {
            if (r.getCondition().equalsIgnoreCase(condition)){
                r.activate(this,enemy,battle);
            }
        }
    }

    //selain itu
    public void activateRelic(String condition){
        for (Relic r:relic) {
            if (r.getCondition().equalsIgnoreCase(condition)){
                r.activate(this);
            }
        }
    }

    public void deactivateRelic(){
        for (Relic r:relic) {
            r.deactivate(this);
        }
    }
    //remove torpedo
    public void removeDisposeCard(){
        for (Card c: card){
            if(c.isDispose()){
                card.remove(c);
            }
        }
    }

    public Potion getPotion(int index){
        return potion.get(index);
    }

    public ArrayList<Potion> getPotion() {
        return potion;
    }

    public Relic getRelic(int index) { return relic.get(index); }

    public ArrayList<Relic> getRelic() {
        return relic;
    }

    public Card getCard(int index){
        return card.get(index);
    }

    public ArrayList<Card> getCard() {
        return card;
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

    public int getWeak() {
        return weak;
    }

    public void setWeak(int weak) {
        this.weak = weak;
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
                '}';
    }
}
