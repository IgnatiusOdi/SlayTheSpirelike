package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Kapal.*;

public abstract class Potion {
    //type ada 3
    //self: bekerja langsung kepada player
    //enemy: bekerja langsung pada enemy
    //battle: bekerja pada battle
    //special: yang butuh kondisi sendiri
    protected String nama,type,rarity;
    protected boolean active;

    public Potion(String nama, String type, String rarity) {
        this.nama = nama;
        this.type = type;
        this.active = true;
        this.rarity = rarity;
    }

    public void activate(Kapal kapal){

    }

    //hanya jalan saat active == false dan ketika turn di battle berakhir
    //saat battle end, semua potion yang masih active langsung deactivate tanpa pengecekan active
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
