package com.SlayTheSpirelike;

public class Enemy {
    protected String nama;
    protected int health,maxhealth, skill, skillchance, atklow, atkhigh;

    public Enemy(String nama, int health, int skill, int skillchance, int atklow, int atkhigh) {
        this.nama = nama;
        this.health = health;
        this.maxhealth = health;
        this.skill = skill;
        this.skillchance = skillchance;
        this.atklow = atklow;
        this.atkhigh = atkhigh;
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
