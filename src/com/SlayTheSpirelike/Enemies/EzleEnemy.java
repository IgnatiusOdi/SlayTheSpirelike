package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class EzleEnemy extends Enemy {
    public EzleEnemy() {
        super("Ezle", 13, "resources/Ezle.png");
        skill1 = 100;
        snama1 = "Flail";
        desc1 = "Deal 3 damage,\n" +
                "gain 3 block";
    }

    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,3);
        enemy.setBlock(enemy.getBlock()+3);
    }

    @Override
    public Enemy copy() {
        return new EzleEnemy();
    }
}
