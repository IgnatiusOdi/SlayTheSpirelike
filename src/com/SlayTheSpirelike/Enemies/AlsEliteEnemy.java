package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class AlsEliteEnemy extends Enemy {
    public AlsEliteEnemy() {
        super("Als (Elite)","Elite", 25, "resources/ALS_Elite.png");
        skill1=30;
        skill2=30;
        skill3=40;
        snama1="Taunt";
        snama2="Defensive Stance";
        snama3="Strong Attack";
        desc1="Apply 2 weak,\n" +
                "deal 5 damage";
        desc2="Gain 10 block\n" +
                "and 2 steel";
        desc3="Deal 9 Damage";
    }
    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        kapal.setWeak(kapal.getWeak()+2);
        attack(kapal,enemy,battle,5);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        enemy.setBlock(enemy.getBlock()+10);
        enemy.setSteel(enemy.getSteel()+2);
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
