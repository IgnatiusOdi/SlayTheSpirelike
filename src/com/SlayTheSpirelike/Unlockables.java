package com.SlayTheSpirelike;

import com.SlayTheSpirelike.Achivement.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Unlockables {
    private static HashMap<String, Boolean> unlockables = new HashMap<>();
    private static HashSet<String> defeated = new HashSet<>();

    private static ArrayList<Achivement> achivementList = new ArrayList<>(8);


    static {
        achivementList.add(new EndOfGame());
        achivementList.add(new FirstTime());
        achivementList.add(new Cheater());
        achivementList.add(new Shopaholic());
        achivementList.add(new IHaveSeenEnough());
        achivementList.add(new BeatKoD());
        achivementList.add(new CantShakeTheAir());

        for (Achivement achivement : achivementList) {
            unlockables.putIfAbsent(achivement.getName(),false);
        }

//        unlockables.putIfAbsent(new EndOfGame(),false);
//        unlockables.putIfAbsent(new FirstTime(),false);
//        unlockables.putIfAbsent(new Cheater(),false);
//        unlockables.putIfAbsent(new Shopaholic(),false);
//        unlockables.putIfAbsent(new IHaveSeenEnough(),false);
//        unlockables.putIfAbsent(new BeatKoD(),false);
//        unlockables.putIfAbsent(new CantShakeTheAir(),false);
        try {
            File f = new File("saves/unlockables.dat");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] content = data.split("=");
                unlockables.putIfAbsent(content[0], Boolean.valueOf(content[1]));
                unlockables.computeIfPresent(content[0], (s, aBoolean) -> Boolean.valueOf(content[1]));
/*                for (Achivement A : unlockables.keySet()) {
                    if (A.getName().equals(content[0])){
                        unlockables.computeIfPresent(A,(s, aBoolean) -> Boolean.valueOf(content[1]));
                    }
                }*/
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            try {
                File f = new File("saves/unlockables.dat");
                if (f.getParentFile().mkdirs()) {
                    if (f.createNewFile()) {
                        System.out.println("File created: " + f.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                } else {
                    System.out.println("Cannot make directory");
                }
            } catch (IOException IOe) {
                System.out.println("An error occurred.");
                IOe.printStackTrace();
            }
        }

//        unlockables.putIfAbsent("ship2Unlock",false);
//        unlockables.putIfAbsent("ship3Unlock",false);

    }

    public static Boolean get(String key){
        return unlockables.get(key);
    }

    public static void reset(){
        unlockables.forEach((s, aBoolean) -> aBoolean = false);
    }

    public static void unlock(String name){
        unlockables.computeIfPresent(name,(s, aBoolean) -> true);
/*        for ( Achivement A :Unlockables.unlockables.keySet()  ) {
            if (A.getName().equals(name)){
                unlockables.computeIfPresent(A,(s, aBoolean) -> true);
            }
        }*/
        save();
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

    public static void killed(String enemy){
        defeated.add(enemy);
        if (defeated.size()>=10){
            Unlockables.unlock("I have seen enough");
        }
    }
}
