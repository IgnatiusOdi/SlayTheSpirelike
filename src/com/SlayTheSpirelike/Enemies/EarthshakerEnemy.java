package com.SlayTheSpirelike.Enemies;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Enemy;
import com.SlayTheSpirelike.Kapal;

public class EarthshakerEnemy extends Enemy {
    private boolean first;
    private int sk1, sk3;
    public EarthshakerEnemy() {
        super("Earthshaker", 40, "resources/earthshaker.png");
        skill1=50;
        skill2=20;
        skill3=30;
        snama1="Weak Attack";
        snama2="Strong Attack";
        snama3="Siphon Soul";
        desc1="Deal 10 Damage";
        desc2="Deal 20 Damage";
        desc3="Inflict 2 weak\n" +
                "and reduce 2 block";
        first=true;
        sk1 = 0;
        sk3 = 0;
    }

    @Override
    public void useSkill(Kapal kapal, Enemy enemy, Battle battle) {
        if (first){
            useSkill3(kapal, enemy, battle);
            first=false;
            sk1 = 0;
            sk3++;
        }
        else {
            boolean skilled=true;
            do{
                int chance = rnd.nextInt(100)+1;
                if(chance<=skill1&&sk1<2){
                    useSkill1(kapal, enemy, battle);
                    sk1++;
                    sk3 = 0;
                    skilled=false;
                }
                else if(chance<=skill1+skill2){
                    useSkill2(kapal, enemy, battle);
                    sk1 = 0;
                    sk3 = 0;
                    skilled=false;
                }
                else if(chance<=skill1+skill2+skill3&&sk3<1){
                    useSkill3(kapal, enemy, battle);
                    sk1 = 0;
                    sk3++;
                    skilled=false;
                }
            }while (skilled);
        }
    }


    @Override
    public void useSkill1(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,10);
    }

    @Override
    public void useSkill2(Kapal kapal, Enemy enemy, Battle battle) {
        attack(kapal,enemy,battle,20);
    }

    @Override
    public void useSkill3(Kapal kapal, Enemy enemy, Battle battle) {
        kapal.setWeak(kapal.getWeak()+2);
        kapal.setBlock(kapal.getBlock()-2);
        if (kapal.getBlock()<0){
            kapal.setBlock(0);
        }
    }

}
