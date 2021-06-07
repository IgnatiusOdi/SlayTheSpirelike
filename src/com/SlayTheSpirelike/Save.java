package com.SlayTheSpirelike;

import com.SlayTheSpirelike.MapItems.MapTile;

import java.io.Serializable;

public class Save implements Serializable {
    private Kapal player;
    private MapTile[][] mapTiles;

    public Save(Map map) {
        this.player = map.getPlayer();
        this.mapTiles = map.getMapTiles();
    }

    public MapTile[][] getMapTiles() {
        return mapTiles;
    }

    public Kapal getPlayer() {
        return player;
    }
}
