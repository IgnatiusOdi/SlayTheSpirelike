package com.SlayTheSpirelike;


import com.SlayTheSpirelike.Cards.AttackCard;
import com.SlayTheSpirelike.Cards.DefendCard;
import com.SlayTheSpirelike.Cards.GatlingGunCard;

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
