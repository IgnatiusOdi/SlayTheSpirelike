package com.SlayTheSpirelike.Relics;

import com.SlayTheSpirelike.HeliSummon;
import com.SlayTheSpirelike.Kapal;
import com.SlayTheSpirelike.Relic;

public class TechnicianRelic extends Relic {
    public TechnicianRelic() {
        super("Technician Relic", "Special", "Start Battle", "resources/summoner relic.png","When battle start, \n" +
                "summon 1 heli to help you");
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&&kapal.isAlive()){
            kapal.summon(new HeliSummon());
            active=false;
        }
    }
}
