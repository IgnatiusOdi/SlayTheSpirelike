package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class AlsCommonEnemy extends Enemy {
    public AlsCommonEnemy() {
        super("Als (Common)","Common", 20, "resources/ALS_Common.png");
        skill1=50;
        skill2=50;
        snama1="Weak Attack";
        snama2="Harden";
        desc1="Deal 5 damage";
        desc2="Gain 5 block";
    }

    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,5);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        enemy.setBlock(enemy.getBlock()+5);
    }

    @Override
    public Enemy copy() {
        return new AlsCommonEnemy();
    }
}
