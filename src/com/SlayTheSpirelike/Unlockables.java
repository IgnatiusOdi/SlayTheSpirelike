package com.SlayTheSpirelike;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Unlockables {
    private static HashMap<String, Boolean> unlockables = new HashMap<>();

    static {
        try {
            File myObj = new File("saves/unlockables.dat");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] content = data.split("=");
                unlockables.putIfAbsent(content[0], Boolean.valueOf(content[1]));
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            try {
                File myObj = new File("saves/unlockables.dat");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException IOe) {
                System.out.println("An error occurred.");
                IOe.printStackTrace();
            }
        }

        unlockables.putIfAbsent("ship2Unlock",false);
        unlockables.putIfAbsent("ship3Unlock",false);
    }

    public static Boolean get(String key){
        return unlockables.get(key);
    }

    public static void reset(){
        unlockables.forEach((s, aBoolean) -> aBoolean = false);
    }

    public static void unlock(String name){
        unlockables.computeIfPresent(name,(s, aBoolean) -> true);
    }

    public static void save(){
        try {
            FileWriter myWriter = new FileWriter("saves/unlockables.dat");
            unlockables.forEach((s, aBoolean) -> {
                try {
                    myWriter.write(s + "=" + aBoolean + "\n");
                } catch (IOException e) {
                    System.out.println("Cannot write to file");
                    e.printStackTrace();
                }
            });
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
