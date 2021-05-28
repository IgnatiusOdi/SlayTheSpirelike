package com.SlayTheSpirelike;

public class PiercingBulletCard extends Card{
    private boolean twiced;
    private boolean used;
    public PiercingBulletCard() {
        super("Piercing Bullet", "Self", 3);
        status();
        twiced = false;
        used = true;
    }

    @Override
    public void activate(Kapal kapal) {
        if (used&&active&& kapal.isAlive()){
            if (twice>1) twiced = true;
            for (int i = 0; i < twice; i++) {
                kapal.setAttack(kapal.getAttack()+strength);
            }
            super.activate(kapal);
            active=true;
            used=false;
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
            strength=3;
        }
        desc = "Gain "+strength+" attack for the \n" +
                "rest of the battle";
    }
}
