package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class AlsEliteEnemy extends Enemy {
    public AlsEliteEnemy() {
        super("Als (Elite)","Elite", 20, "resources/ALS_Elite.png");
        skill1=30;
        skill2=30;
        skill3=40;
        snama1="Taunt";
        snama2="Defensive Stance";
        snama3="Strong Attack";
        desc1="Apply 1 weak,\n" +
                "deal 2 damage";
        desc2="Gain 4 block\n" +
                "and 1 steel";
        desc3="Deal 9 Damage";
    }
    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        kapal.setWeak(kapal.getWeak()+1);
        attack(kapal,enemy,battle,2);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        enemy.setBlock(enemy.getBlock()+4);
        enemy.setSteel(enemy.getSteel()+1);
    }

    @Override
    public void useSkill3(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,9);
    }

    @Override
    public Enemy copy() {
        return new AlsEliteEnemy();
    }
}
