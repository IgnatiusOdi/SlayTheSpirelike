package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class KingOfDestroyerEnemy extends Enemy {
    private int ctr;
    public KingOfDestroyerEnemy() {
        super("King of Destroyer", 50, "resources/Kingdestroyer.png");
        skill1=70;
        skill2=30;
        snama1="Count";
        snama2="Glare";
        snama3="It Is Time";
        desc1="Deal 5 Damage";
        desc2="Apply 1 weak";
        desc3="Deal 30 Damage";
        ctr=0;
    }

    @Override
    public void useSkill(Kapal kapal, Enemy enemy, Battle battle) {
        if (ctr>=2){
            useSkill3(kapal, enemy, battle);
            ctr=0;
        }
        else {
            super.useSkill(kapal, enemy, battle);
            ctr++;
        }
    }


    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,5);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        kapal.setWeak(kapal.getWeak()+1);
    }

    @Override
    public void useSkill3(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,30);
    }
}
