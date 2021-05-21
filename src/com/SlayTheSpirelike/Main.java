package com.SlayTheSpirelike;

/**
 * Slay the Spirelike <br>
 * Alexander Kevin <br>
 * Ignatius Odi <br>
 * Airlangga <BR>
 * Abraham Arthur <br>
 */

public class Main {

    public static void main(String[] args) {
//        new Statics();//initialize static potions
        Body body = new Body(1162,648);
        body.setLocationRelativeTo(null);
        body.setPanel(new Shop(body));

//        new SummonPotion();
//        new InvinciblePotion();
//        new RevivePotion();

//        Kapal k = new Aircraft("nama");

//        Potion b = new BrewPotion();
//        b.activate(k);
//        k.viewPotion();

//        Potion p = new AttackPotion();
//        p.activate(k);
//        System.out.println(k);
//        p.deactivate(k);
//        System.out.println(k);

//        k.obtainPotion(new AttackPotion());
//        System.out.println(k.isPotion("Attack Potion"));
//        System.out.println(k.isAlive());

    }
}
