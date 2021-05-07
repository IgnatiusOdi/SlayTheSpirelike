package com.SlayTheSpirelike;

public class Tanker extends Kapal{
    public Tanker(String nama) {
        super(nama);
        this.health = this.health*140/100;
        this.maxhealth = this.maxhealth*140/100;
    }
}
