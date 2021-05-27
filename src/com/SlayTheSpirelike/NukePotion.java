package com.SlayTheSpirelike;

public class NukePotion extends Potion{
    public NukePotion() {
        super("Nuke Potion", "Enemy", "Common", "resources/NukePotion.png","Deal 5 damage \n" +
                "to enemies");
    }
    @Override
    public void activate(Enemy enemy) {
        if (active){
            enemy.setHealth(enemy.getHealth()-5);
            active=false;
        }
    }

}
