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
    public void activate(Kapal k) {
        if (used&&active&&k.isAlive()){
            if (twice>1) twiced = true;
            for (int i = 0; i < twice; i++) {
                k.setAttack(k.getAttack()+strength);
            }
            super.activate(k);
            active=true;
            used=false;
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
            strength=3;
        }
        desc = "Gain "+strength+" attack for the \n" +
                "rest of the battle";
    }
}
