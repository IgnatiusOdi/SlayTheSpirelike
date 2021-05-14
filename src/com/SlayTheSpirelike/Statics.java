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
        commonPotion.add(new WeakeningPotion());
        commonPotion.add(new HealthPotion());
        commonPotion.add(new NukePotion());
        commonPotion.add(new DuplicationPotion());
        commonPotion.add(new ForgePotion());

        uncommonPotion.add(new WrathPotion());
        uncommonPotion.add(new SteelPotion());
        uncommonPotion.add(new EnergyPotion());
        uncommonPotion.add(new RegenerationPotion());
        uncommonPotion.add(new SwiftPotion());
        uncommonPotion.add(new SmokePotion());

        rarePotion.add(new AppleJuicePotion());
        rarePotion.add(new BrewPotion());
    }
}
