package com.SlayTheSpirelike;

public class MembershipCardRelic extends Relic{
    public MembershipCardRelic() {
        super("Membership Card Relic", "Shop", "Special","resources/MembershipCard.png");
    }

    @Override
    public boolean activate() {
        return active;
    }
}
