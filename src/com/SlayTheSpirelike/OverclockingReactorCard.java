package com.SlayTheSpirelike;

public class OverclockingReactorCard extends Card{
    private boolean twiced;
    public OverclockingReactorCard() {
        super("Overclocking Reactor", "Self", 0);
        status();
        twiced = false;
    }

    @Override
    public void activate(Kapal kapal) {
        if (active&& kapal.isAlive()){
            if (twice>1) twiced = true;
            for (int i = 0; i < twice; i++) {
                kapal.setAttack(kapal.getAttack()+strength);
            }
            finish(kapal);
        }
    }

    @Override
    public void deactivate(Kapal kapal) {
        if (twiced){
            kapal.setAttack(kapal.getAttack()-strength);
            twiced=false;
        }
        kapal.setAttack(kapal.getAttack()-strength);
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
