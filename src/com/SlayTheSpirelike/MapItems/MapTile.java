package com.SlayTheSpirelike.MapItems;

public abstract class MapTile {
    private boolean discovered;
    private String name;

    public boolean isDiscovered() {
        return discovered;
    }

    public void discover(){
        discovered = true;
    }

    public abstract void enterTile();
}
