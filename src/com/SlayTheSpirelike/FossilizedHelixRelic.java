package com.SlayTheSpirelike;

public class FossilizedHelixRelic extends Relic{
    public FossilizedHelixRelic() {
        super("Fossilized Helix Relic", "Rare", "Special", "resources/FossilizedHelix.png");
    }

    @Override
    public boolean activate() {
        boolean prevent = active;
        active = false;
        return prevent;
    }
}
