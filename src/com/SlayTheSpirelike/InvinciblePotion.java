package com.SlayTheSpirelike;

public class InvinciblePotion extends Potion{
    public InvinciblePotion() {
        super("Invincible Potion", "Special", "Special", "resources/InviciblePotion.png","Reduce all damage \n" +
                "to 0 for one turn\n" +
                "(Tanker only)");
    }

    @Override
    public boolean activate(){
        boolean on = active;
        active = false;
        return on;
    }
}
