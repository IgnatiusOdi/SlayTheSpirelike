package com.SlayTheSpirelike;

import javax.swing.*;

public abstract class Enemy extends Sprite {
    protected String nama;
    protected int health,maxhealth,block, skill, skillchance, atklow, atkhigh;

    public Enemy(String nama, int health,int block, int skill, int skillchance, int atklow, int atkhigh, String image) {
        super(image);
        this.nama = nama;
        this.health = health;
        this.maxhealth = health;
        this.block = block;
        this.skill = skill;
        this.skillchance = skillchance;
        this.atklow = atklow;
        this.atkhigh = atkhigh;
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

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getSkillchance() {
        return skillchance;
    }

    public void setSkillchance(int skillchance) {
        this.skillchance = skillchance;
    }

    public int getAtklow() {
        return atklow;
    }

    public void setAtklow(int atklow) {
        this.atklow = atklow;
    }

    public int getAtkhigh() {
        return atkhigh;
    }

    public void setAtkhigh(int atkhigh) {
        this.atkhigh = atkhigh;
    }
}
