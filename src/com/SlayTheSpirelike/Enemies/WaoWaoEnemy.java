package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class WaoWaoEnemy extends Enemy {
    public WaoWaoEnemy() {
        super("Wao Wao", 10, "");
        skill1=60;
        skill2=20;
        skill3=20;
        snama1="Weak Attack";
        snama2="Thrash";
        snama3="Bellow";
        desc1="Deal 4 damage";
        desc2="Deal 6 damage,\n" +
                "gain 3 block";
        desc3="Gain 1 strength,\n" +
                "gain 4 block";
    }

    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,4);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,6);
        enemy.setBlock(enemy.getBlock()+3);
    }

    @Override
    public void useSkill3(Kapal kapal, Enemy enemy, Battle battle) {
        enemy.setAttack(enemy.getAttack()+1);
        enemy.setBlock(enemy.getBlock()+4);
    }
}
