package com.SlayTheSpirelike;

import java.util.ArrayList;

public class Statics {
    //utility untuk dapat potion
    //karena special spesifik untuk tiap kapal, langsung masukan potion ketika dapat special
    public static ArrayList<Potion> commonPotion = new ArrayList();
    public static ArrayList<Potion> uncommonPotion = new ArrayList();
    public static ArrayList<Potion> rarePotion = new ArrayList();

    public static ArrayList<Relic> commonRelic = new ArrayList();
    public static ArrayList<Relic> uncommonRelic = new ArrayList();
    public static ArrayList<Relic> rareRelic = new ArrayList();
    public static ArrayList<Relic> shopRelic = new ArrayList();
    public static ArrayList<Relic> bossRelic = new ArrayList();

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

        commonRelic.clear();
        uncommonRelic.clear();
        rareRelic.clear();
        shopRelic.clear();
        bossRelic.clear();

        commonRelic.add(new CannontizerRelic());
        commonRelic.add(new BagOfPreparationRelic());
        commonRelic.add(new StonedRelic());
        commonRelic.add(new StrawberryRelic());
        commonRelic.add(new TankRelic());
        commonRelic.add(new EmergencyFoodRelic());

        uncommonRelic.add(new PearRelic());
        uncommonRelic.add(new RareCoinRelic());
        uncommonRelic.add(new BurningBloodRelic());
        uncommonRelic.add(new PotionBeltsRelic());
        uncommonRelic.add(new WhiteBeastStatueRelic());

        rareRelic.add(new MangoRelic());
        rareRelic.add(new LizardTailRelic());
        rareRelic.add(new FossilizedHelixRelic());

        shopRelic.add(new MembershipCardRelic());
        shopRelic.add(new CauldronRelic());
        shopRelic.add(new CookieRelic());

        bossRelic.add(new StarterPackRelic());
        bossRelic.add(new PhilosophersStoneRelic());
        bossRelic.add(new SozuRelic());
    }
}
