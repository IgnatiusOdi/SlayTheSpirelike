package com.SlayTheSpirelike;

public class RethinkCard extends Card{
    public RethinkCard() {
        super("Rethink", "Battle", 1);
        status();
    }

    @Override
    public void activate(Kapal kapal, Enemy enemy, Battle battle) {
        if (active&& kapal.isAlive()){
            for (int i = 0; i < twice; i++) {
                kapal.setBlock(kapal.getBlock()+block);
                battle.draw(draw);
            }
            finish(kapal);
        }
    }

    @Override
    public void status() {
        if (level==1){
            block=2;
            draw=1;
        }
        else if(level>=2){
            block=4;
            draw=2;
        }
        desc = "Gain "+block+" block \n" +
                "and draw "+draw+" card";
    }
}
