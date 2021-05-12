package com.SlayTheSpirelike;

import java.util.ArrayList;

public class Statics {
    //utility untuk dapat potion
    //karena special spesifik untuk tiap kapal, langsung masukan potion ketika dapat special
    public static ArrayList<Potion> commonPotion = new ArrayList();
    public static ArrayList<Potion> uncommonPotion = new ArrayList();
    public static ArrayList<Potion> rarePotion = new ArrayList();

    public Statics() {
        commonPotion.clear();
        uncommonPotion.clear();
        rarePotion.clear();
        commonPotion.add(new AttackPotion());
        commonPotion.add(new BlockPotion());
        commonPotion.add(new HealthPotion());

        uncommonPotion.add(new WrathPotion());
        uncommonPotion.add(new SteelPotion());
        uncommonPotion.add(new EnergyPotion());
        uncommonPotion.add(new RegenerationPotion());

        rarePotion.add(new AppleJuicePotion());
    }
}
