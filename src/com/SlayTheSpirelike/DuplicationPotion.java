package com.SlayTheSpirelike;

public class DuplicationPotion extends Potion{
    public DuplicationPotion() {
        super("Duplication Potion", "Battle", "Common", "resources/DuplicationPotion.png","Your next card \n" +
                "is played twice");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            kapal.card.get(0).setTwice(2);
            active=false;
        }
    }
}
