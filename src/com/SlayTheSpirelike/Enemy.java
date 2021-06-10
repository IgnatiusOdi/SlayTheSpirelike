package com.SlayTheSpirelike;

import javax.swing.*;
import java.util.Random;

public abstract class Enemy extends Sprite {
    protected Random rnd = new Random();
    protected String nama,rarity;
    protected int health,maxhealth, block, skill1, skill2, skill3, weak, attack, steel;
    protected String snama1, snama2, snama3, desc1, desc2, desc3;

    public Enemy(String nama,String rarity, int health, String image) {
        super(image);
        this.nama = nama;
        this.rarity = rarity;
        this.health = health;
        this.maxhealth = health;
        this.steel = 0;
        this.block = 0;
        this.weak = 0;
        this.attack = 0;
        this.skill1 = 0;
        this.skill2 = 0;
        this.skill3 = 0;
        this.snama1 = "";
        this.snama2 = "";
        this.snama3 = "";
        this.desc1 = "";
        this.desc2 = "";
        this.desc3 = "";
    }

    public abstract Enemy copy();

    public void steelUp(){
        block+=steel;
    }

    public void attack(Kapal k, Enemy e, Battle b, int damage){
        if(!b.isInvincible()){
            int attack = damage + e.getAttack() - e.getWeak();
            if(attack<0){
                attack=0;
            }
            if (attack>k.getBlock()){
                attack -= k.getBlock();
                k.setBlock(0);
            }
            else{
                k.setBlock(k.getBlock()-attack);
                attack=0;
            }
            k.setHealth(k.getHealth()-attack);
            k.activateRelic("Damaged",e,b);

            //Player lose detection, activate death relic. if player is still dead (no death relic), end battle
            if (!k.isAlive()) {
                k.activateRelic("Death",e,b);
                if (!k.isAlive()) {
                    b.endBattle("e");
                }
            }
        }
        else{
            b.setInvincible(false);
        }
    }

    public void useSkill(Kapal kapal, Enemy enemy, Battle battle){
        int chance = rnd.nextInt(100)+1;
        if(chance<=skill1){
            useSkill1(kapal, enemy, battle);
        }
        else if(chance<=skill1+skill2){
            useSkill2(kapal, enemy, battle);
        }
        else if(chance<=skill1+skill2+skill3){
            useSkill3(kapal, enemy, battle);
        }
    }

    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle){

    }

    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle){

    }

    public void useSkill3(Kapal kapal, Enemy enemy, Battle battle){

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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public void setMaxhealth(int maxhealth) {
        this.maxhealth = maxhealth;
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

    public int getSkill1() {
        return skill1;
    }

    public void setSkill1(int skill1) {
        this.skill1 = skill1;
    }

    public int getSkill2() {
        return skill2;
    }

    public void setSkill2(int skill2) {
        this.skill2 = skill2;
    }

    public int getSkill3() {
        return skill3;
    }

    public void setSkill3(int skill3) {
        this.skill3 = skill3;
    }

    public int getWeak() {
        return weak;
    }

    public void setWeak(int weak) {
        this.weak = weak;
    }

    public String getSnama1() {
        return snama1;
    }

    public void setSnama1(String snama1) {
        this.snama1 = snama1;
    }

    public String getSnama2() {
        return snama2;
    }

    public void setSnama2(String snama2) {
        this.snama2 = snama2;
    }

    public String getSnama3() {
        return snama3;
    }

    public void setSnama3(String snama3) {
        this.snama3 = snama3;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getSteel() {
        return steel;
    }

    public void setSteel(int steel) {
        this.steel = steel;
    }
}
