package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class AK170Enemy extends Enemy {
    public AK170Enemy() {
        super("AK170", 15, "");
        skill1=60;
        skill2=40;
        snama1="Weak Attack";
        snama2="Corrosive";
        desc1="Deal 3 damage";
        desc2="Inflict 1 weak";
    }

    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,3);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        kapal.setWeak(kapal.getWeak()+1);
    }
}
