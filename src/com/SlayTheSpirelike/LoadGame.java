package com.SlayTheSpirelike;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadGame {

    public LoadGame(Map map){
        Save save;
        try {
            FileInputStream fileIn = new FileInputStream("saves/save1.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            save = (Save) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Save class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Load success");
        save.getPlayer().reConstruct();
        map.setPlayer(save.getPlayer());
        map.setMapTiles(save.getMapTiles());
        map.reConstruct();
    }
}
