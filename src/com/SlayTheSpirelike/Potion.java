package com.SlayTheSpirelike;

public abstract class Potion {
    protected String nama,type;
    protected boolean active;

    public Potion(String nama, String type) {
        this.nama = nama;
        this.type = type;
        this.active = true;
    }

    public void activate(Kapal kapal){

    }

    //hanya jalan saat active == false ketika turn di battle berakhir
    public void deactivate(Kapal kapal){

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
