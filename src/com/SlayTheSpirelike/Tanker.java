package com.SlayTheSpirelike;


public class Tanker extends Kapal {
    public Tanker(String nama) {
        super(nama,"resources/tanker.png");
        this.health = this.health*140/100;
        this.maxhealth = this.maxhealth*140/100;
        card.add(new AttackCard());
        card.add(new AttackCard());
        card.add(new AttackCard());
        card.add(new DefendCard());
        card.add(new DefendCard());
        card.add(new DefendCard());
        card.add(new DefendCard());
        card.add(new DefendCard());
        card.add(new DefendCard());
        //heal card
    }
}
