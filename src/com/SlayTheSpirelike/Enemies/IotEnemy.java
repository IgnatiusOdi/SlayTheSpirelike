package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class IotEnemy extends Enemy {
    public IotEnemy() {
        super("Iot","Elite", 30, "resources/IOT.png");
        skill1=30;
        skill2=60;
        skill3=10;
        snama1="Menancing";
        snama2="Weak Attack";
        snama3="Strong Attack";
        desc1="Gain 1 strength";
        desc2="Deal 4 Damage";
        desc3="Deal 9 Damage";
    }

    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        enemy.setAttack(enemy.getAttack()+1);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,4);
    }

    @Override
    public void useSkill3(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,9);
    }

    @Override
    public Enemy copy() {
        return new IotEnemy();
    }
}
