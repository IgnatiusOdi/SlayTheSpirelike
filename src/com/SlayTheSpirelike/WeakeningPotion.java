package com.SlayTheSpirelike;

public class WeakeningPotion extends Potion{
    private boolean used;
    public WeakeningPotion() {
        super("Weakening Potion", "Enemy", "Common", "resources/WeakPotion.png","Decrease enemy \n" +
                "attack by 5");
        used = true;
    }

    @Override
    public void activate(Enemy enemy) {
        if (active&&used){
            enemy.setAtkhigh(enemy.getAtkhigh()-5);
            enemy.setAtklow(enemy.getAtklow()-5);
            used = false;
        }
    }

    @Override
    public void deactivate(Enemy enemy) {
        enemy.setAtkhigh(enemy.getAtkhigh()+5);
        enemy.setAtklow(enemy.getAtklow()+5);
    }
}
