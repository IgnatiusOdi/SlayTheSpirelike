package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class CungEnemy extends Enemy {
    public CungEnemy() {
        super("Cung","Common", 15, "resources/Cung.png");
        skill1=60;
        skill2=40;
        snama1="Weak Attack";
        snama2="Grow";
        desc1="Deal 2 damage";
        desc2="Gain 2 strength";
    }

    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,2);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        enemy.setAttack(enemy.getAttack()+2);
    }

    @Override
    public Enemy copy() {
        return new CungEnemy();
    }
}
