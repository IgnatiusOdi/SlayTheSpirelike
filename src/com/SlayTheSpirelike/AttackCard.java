package com.SlayTheSpirelike;

public class AttackCard extends Card{
    public AttackCard() {
        super("Attack", "Enemy", 1);
        status();
    }

    @Override
    public void activate(Kapal k, Enemy e) {
        super.activate(k, e);
        attack(k,e);
    }

    @Override
    public void status() {
        if (level==1){
            damage=4;
            desc = "Deal "+damage+" damage \n" +
                    "to enemy";
        }
    }

    @Override
    public void upgrade() {

    }
}
