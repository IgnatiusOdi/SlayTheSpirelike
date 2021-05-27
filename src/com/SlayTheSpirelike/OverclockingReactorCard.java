package com.SlayTheSpirelike;

public class OverclockingReactorCard extends Card{
    private boolean twiced;
    public OverclockingReactorCard() {
        super("Overclocking Reactor", "Self", 0);
        status();
        twiced = false;
    }

    @Override
    public void activate(Kapal k) {
        if (active&&k.isAlive()){
            if (twice>1) twiced = true;
            for (int i = 0; i < twice; i++) {
                k.setAttack(k.getAttack()+strength);
            }
            super.activate(k);
        }
    }

    @Override
    public void deactivate(Kapal k) {
        if (twiced){
            k.setAttack(k.getAttack()-strength);
            twiced=false;
        }
        k.setAttack(k.getAttack()-strength);
    }

    @Override
    public void status() {
        if (level==1){
            strength=2;
        }
        else if(level>=2){
            strength=4;
        }
        desc = "Gain "+strength+" attack \n" +
                "for one turn";
    }
}
