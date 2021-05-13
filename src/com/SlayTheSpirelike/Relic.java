package com.SlayTheSpirelike;

public class Relic {
    protected String nama,rarity,condition;
    protected boolean active;

    public Relic(String nama, String rarity, String condition) {
        this.nama = nama;
        this.rarity = rarity;
        this.active = true;
        this.condition = condition;
    }

    //relic yang tidak memiliki override cara kerjanya adalah, ketika kondisi tercapai, kalau ada relic ini, activate kode yang tempat itu
    public void activate(Kapal kapal){

    }

    public void deactivate(Kapal kapal){

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
