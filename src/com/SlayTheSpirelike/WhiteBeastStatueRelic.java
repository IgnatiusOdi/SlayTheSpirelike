package com.SlayTheSpirelike;

public class WhiteBeastStatueRelic extends Relic{
    public WhiteBeastStatueRelic() {
        super("White Beast Statue Relic", "Uncommon", "Special","resources/WhiteBeastStatue.png");
    }

    @Override
    public boolean activate() {
        return active;
    }
}
