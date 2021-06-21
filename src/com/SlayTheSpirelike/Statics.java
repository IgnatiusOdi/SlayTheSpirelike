package com.SlayTheSpirelike;

import com.SlayTheSpirelike.Cards.*;
import com.SlayTheSpirelike.Enemies.*;
import com.SlayTheSpirelike.Potions.*;
import com.SlayTheSpirelike.Relics.*;

import java.util.ArrayList;

public class Statics {
    //utility untuk dapat potion
    //karena special spesifik untuk tiap kapal, langsung masukan potion ketika dapat special
    public static ArrayList<Potion> commonPotion = new ArrayList<>();
    public static ArrayList<Potion> uncommonPotion = new ArrayList<>();
    public static ArrayList<Potion> rarePotion = new ArrayList<>();

    public static ArrayList<Relic> commonRelic = new ArrayList<>();
    public static ArrayList<Relic> uncommonRelic = new ArrayList<>();
    public static ArrayList<Relic> rareRelic = new ArrayList<>();
    public static ArrayList<Relic> shopRelic = new ArrayList<>();
    public static ArrayList<Relic> bossRelic = new ArrayList<>();

    public static ArrayList<Card> commonCards = new ArrayList<>();
    public static ArrayList<Card> tankerCards = new ArrayList<>();
    public static ArrayList<Card> warshipCards = new ArrayList<>();
    public static ArrayList<Card> aircraftCards = new ArrayList<>();

    public static ArrayList<Enemy> commonEnemy = new ArrayList<>();
    public static ArrayList<Enemy> eliteEnemy = new ArrayList<>();

    static {
//        commonPotion.clear();
//        uncommonPotion.clear();
//        rarePotion.clear();

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

        uncommonPotion.add(new SwiftPotion());
        uncommonPotion.add(new SmokePotion());

        rarePotion.add(new AppleJuicePotion());
        rarePotion.add(new BrewPotion());
        rarePotion.add(new RegenerationPotion());

//        commonRelic.clear();
//        uncommonRelic.clear();
//        rareRelic.clear();
//        shopRelic.clear();
//        bossRelic.clear();

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

//        cards.clear();
        commonCards.add(new AttackCard());
        commonCards.add(new DefendCard());
        commonCards.add(new GreedofPotCard());
        commonCards.add(new RechargeCard());
        commonCards.add(new InspiringShotCard());
        commonCards.add(new FlakgunCard());
        commonCards.add(new PlasmaNapalmCard());
        commonCards.add(new SalvationCard());

        tankerCards.add(new HeavyArtileryCard());
        tankerCards.add(new OverclockingReactorCard());
        tankerCards.add(new FortifyCard());
        tankerCards.add(new RethinkCard());
        tankerCards.add(new OneforAllCard());
        tankerCards.add(new RerouteCard());
        tankerCards.add(new ExplodingPayloadCard());
        tankerCards.add(new MissleCard());
        tankerCards.add(new ExtraGunpowderCard());
        tankerCards.add(new SupportCannonCard());
        tankerCards.add(new HealCard());

        warshipCards.add(new SniperShotCard());
        warshipCards.add(new RocketSalvoCard());
        warshipCards.add(new CommandersWisdom());
        warshipCards.add(new RepositionCard());
        warshipCards.add(new LoadUpCard());
        warshipCards.add(new CounterplayCard());
        warshipCards.add(new GatlingGunCard());
        warshipCards.add(new DeflectCard());
        warshipCards.add(new PiercingShotCard());
        warshipCards.add(new StrategicShotCard());
        warshipCards.add(new FuelContainerCard());
        warshipCards.add(new SalvageCard());

        aircraftCards.add(new HelicallCard());
        aircraftCards.add(new SupportFlareCard());
        aircraftCards.add(new DeniumShieldingCard());
        aircraftCards.add(new MoralSupportCard());
        aircraftCards.add(new AllOutAttackCard());
        aircraftCards.add(new SupportFlareV2Card());
        aircraftCards.add(new SelfRepairCard());
        aircraftCards.add(new BufferCard());
        aircraftCards.add(new CombustCard());
        aircraftCards.add(new KamikazeCard());

        commonEnemy.add(new EzleEnemy());
        commonEnemy.add(new KosmasEnemy());
        commonEnemy.add(new WaoWaoEnemy());
        commonEnemy.add(new CungEnemy());
        commonEnemy.add(new AlsCommonEnemy());
        commonEnemy.add(new AK170Enemy());

        eliteEnemy.add(new IotEnemy());
        eliteEnemy.add(new AlsEliteEnemy());
    }
}
