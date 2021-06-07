package com.SlayTheSpirelike.MapItems;

import com.SlayTheSpirelike.Body;
import com.SlayTheSpirelike.Kapal;

import javax.swing.*;
import java.io.Serializable;

public abstract class MapTile implements Serializable {
    private boolean discovered;
    private String name;

    public boolean isDiscovered() {
        return discovered;
    }

    public void discover(){
        discovered = true;
    }

    public abstract void enterTile();

    public abstract void reInit(Body body, JPanel returnPanel, Kapal player);
}
