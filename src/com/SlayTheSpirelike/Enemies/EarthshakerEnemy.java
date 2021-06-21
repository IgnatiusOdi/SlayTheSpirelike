package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class EarthshakerEnemy extends Enemy {
    private boolean first;
    private int sk1, sk3;
    public EarthshakerEnemy() {
        super("Earthshaker","Boss", 40, "resources/earthshaker.png");
        skill1=50;
        skill2=20;
        skill3=30;
        snama1="Weak Attack";
        snama2="Strong Attack";
        snama3="Siphon Soul";
        desc1="Deal 6 Damage";
        desc2="Deal 11 Damage";
        desc3="Inflict 1 weak\n" +
                "and reduce 1 block";
        first=true;
        sk1 = 0;
        sk3 = 0;
    }

    @Override
    public String setSkill() {
        String skill="";
        if (first){
            skill = snama3;
            sk1 = 0;
            sk3++;
        }
        else {
            boolean skilled=true;
            do{
                chance = rnd.nextInt(100)+1;
                if(chance<=skill1&&sk1<2){
                    skill = snama1;
                    sk1++;
                    sk3 = 0;
                    skilled=false;
                }
                else if(chance<=skill1+skill2){
                    skill = snama2;
                    sk1 = 0;
                    sk3 = 0;
                    skilled=false;
                }
                else if(chance<=skill1+skill2+skill3&&sk3<1){
                    skill = snama3;
                    sk1 = 0;
                    sk3++;
                    skilled=false;
                }
            }while (skilled);
        }
        return skill;
    }

    @Override
    public String getNextSkillDesc() {
        if (first){
            return desc3;
        }
        else{
            return super.getNextSkillDesc();
        }
    }

    @Override
    public void useSkill(Kapal kapal, Enemy enemy, Battle battle) {
        if (first){
            useSkill3(kapal, enemy, battle);
            first=false;
        }
        else {
            super.useSkill(kapal,enemy,battle);
        }
    }


    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,6);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,11);
    }

    @Override
    public void useSkill3(Kapal kapal, Enemy enemy, Battle battle) {
        kapal.setWeak(kapal.getWeak()+1);
        kapal.setBlock(kapal.getBlock()-1);
        if (kapal.getBlock()<0){
            kapal.setBlock(0);
        }
    }

    @Override
    public Enemy copy() {
        return new EarthshakerEnemy();
    }
}
