package com.SlayTheSpirelike.Potions;

import com.SlayTheSpirelike.Battle;
import com.SlayTheSpirelike.Potion;

public class SwiftPotion extends Potion {
    public SwiftPotion() {
        super("Swift Potion", "Battle", "Uncommon", "resources/SwiftPotion.png","Draw 3 card");
    }
    @Override
    public void activate(Battle battle) {
        if (active){
            battle.draw(3);
            active=false;
        }
    }
}
