package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class EzleEnemy extends Enemy {
    public EzleEnemy() {
        super("Ezle","Common", 13, "resources/Ezle.png");
        skill1 = 100;
        snama1 = "Flail";
        desc1 = "Deal 4 damage,\n" +
                "gain 2 block";
    }

    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,4);
        enemy.setBlock(enemy.getBlock()+2);
    }

    @Override
    public Enemy copy() {
        return new EzleEnemy();
    }
}
