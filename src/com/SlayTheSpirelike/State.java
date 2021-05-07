package com.SlayTheSpirelike;

import java.awt.Graphics;

public abstract class State {
    public abstract void render(Graphics g);
    public abstract void tick(); 
    
    public static State current;

    public static State getCurrent() {
        return current;
    }

    public static void setCurrent(State current) {
        State.current = current;
    }
    
}
