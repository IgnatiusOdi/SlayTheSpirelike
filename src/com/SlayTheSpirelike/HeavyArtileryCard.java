package com.SlayTheSpirelike;

public class HeavyArtileryCard extends Card{
    public HeavyArtileryCard() {
        super("Heavy Artilery", "Enemy", 2);
        status();
    }
    @Override
    public void activate(Kapal kapal, Enemy enemy) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                attack(kapal, enemy);
                enemy.setAtkhigh(enemy.getAtkhigh()-weak);
                enemy.setAtklow(enemy.getAtklow()-weak);
                if (enemy.getAtkhigh()<0){
                    enemy.setAtkhigh(0);
                }
                if (enemy.getAtklow()<0){
                    enemy.setAtklow(0);
                }
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            damage=4;
            weak=2;
        }
        else if(level>=2){
            damage=6;
            weak=3;
        }
        desc = "Deal "+damage+" damage \n" +
                "and apply "+weak+" weak";
    }

}


