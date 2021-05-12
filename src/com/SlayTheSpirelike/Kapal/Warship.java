package com.SlayTheSpirelike.Kapal;


public class Warship extends Kapal {
    public Warship(String nama) {
        super(nama);
        this.health -=5;
        this.maxhealth -=5;
    }
}
