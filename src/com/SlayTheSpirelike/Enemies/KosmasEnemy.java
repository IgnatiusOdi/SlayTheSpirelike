package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class KosmasEnemy extends Enemy {
    public KosmasEnemy() {
        super("Kosmas","Common", 6, "");
        skill1=50;
        skill2=50;
        snama1="Defend";
        snama2="Weak Attack";
        desc1="Gain 3 block";
        desc2="Deal 2 damage";
    }

    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        enemy.setBlock(enemy.getBlock()+3);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,2);
    }
}
