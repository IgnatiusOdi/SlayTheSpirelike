package com.SlayTheSpirelike;

import java.io.*;

public class SaveGame implements Serializable{

    public SaveGame(Map map) {
        Save save = new Save(map);

        try {
            FileOutputStream fileOut = new FileOutputStream("saves/save1.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(save);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in saves/save1.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

