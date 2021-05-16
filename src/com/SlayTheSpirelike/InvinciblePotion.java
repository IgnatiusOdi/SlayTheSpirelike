package com.SlayTheSpirelike;

public class InvinciblePotion extends Potion{
    public InvinciblePotion() {
        super("Invincible Potion", "Special", "Special", "resources/InviciblePotion.png");
    }

    @Override
    public boolean activate(){
        boolean on = active;
        active = false;
        return on;
    }
}
