package com.SlayTheSpirelike;

public class Potion {
    protected String nama,type;
    protected int duration;
    protected boolean active;

    public Potion(String nama, String type, int duration) {
        this.nama = nama;
        this.type = type;
        this.duration = duration;
        this.active = true;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
