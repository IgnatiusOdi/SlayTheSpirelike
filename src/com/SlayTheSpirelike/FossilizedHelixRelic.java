package com.SlayTheSpirelike;

public class FossilizedHelixRelic extends Relic{
    public FossilizedHelixRelic() {
        super("Fossilized Helix Relic", "Rare", "Special", "resources/FossilizedHelix.png","Prevent the first \n" +
                "time you would lose \n" +
                "health in battle");
    }

    @Override
    public boolean activate() {
        boolean prevent = active;
        active = false;
        return prevent;
    }
}
