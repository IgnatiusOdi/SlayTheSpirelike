package com.SlayTheSpirelike;


public class Warship extends Kapal {
    public Warship(String nama) {
        super(nama,"resources/warship.png");
        this.health -=5;
        this.maxhealth -=5;
        card.add(new AttackCard());
        card.add(new AttackCard());
        card.add(new AttackCard());
        card.add(new AttackCard());
        card.add(new AttackCard());
        card.add(new AttackCard());
        card.add(new DefendCard());
        card.add(new DefendCard());
        card.add(new DefendCard());
        card.add(new GatlingGunCard());
    }
}
