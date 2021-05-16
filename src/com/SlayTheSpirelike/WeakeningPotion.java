package com.SlayTheSpirelike;

public class WeakeningPotion extends Potion{
    public WeakeningPotion() {
        super("Weakening Potion", "Enemy", "Common", "resources/WeakPotion.png");
    }

    @Override
    public void activate(Enemy enemy) {
        if (active){
            enemy.setAtkhigh(enemy.getAtkhigh()-5);
            enemy.setAtklow(enemy.getAtklow()-5);
            active=false;
        }
    }

    @Override
    public void deactivate(Enemy enemy) {
        enemy.setAtkhigh(enemy.getAtkhigh()+5);
        enemy.setAtklow(enemy.getAtklow()+5);
    }
}
