package com.SlayTheSpirelike;

public class Aircraft extends Kapal {
    public Aircraft(String nama) {
        super(nama,"resources/aircraft.png");
        card.add(new AttackCard());
        card.add(new AttackCard());
        card.add(new AttackCard());
        card.add(new AttackCard());
        card.add(new DefendCard());
        card.add(new DefendCard());
        card.add(new DefendCard());
        card.add(new DefendCard());
        card.add(new HelicallCard());
        card.add(new HelicallCard());
    }
}
