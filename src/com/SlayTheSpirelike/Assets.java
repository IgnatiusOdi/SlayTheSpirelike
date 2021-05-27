package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage     mainMenuBackground_old, battle1BG,
                                    tanker,warship,carrier,
                                    board, plank1,plank2,plank3,
                                    map, enemyTile, treasureTile, fuelTile, shopTile,
                                    arrowRight, arrowDown, arrowLeft, arrowUp,
                                    fuelTank,coin,heart,energy;

    public static ImageIcon mainMenuBG;
    
    static {
        mainMenuBG = new ImageIcon("resources/mainMenu.png");
        mainMenuBackground_old = ImageLoader.LoadImage("resources/mainMenu.png");
        battle1BG = ImageLoader.LoadImage("resources/battle1.png");
        tanker = ImageLoader.LoadImage("resources/tanker.png");
        warship = ImageLoader.LoadImage("resources/warship.png");
        carrier = ImageLoader.LoadImage("resources/aircraft.png");
        fuelTank = ImageLoader.LoadImage("resources/tank.png");
        coin = ImageLoader.LoadImage("resources/coin.png");
        heart = ImageLoader.LoadImage("resources/health.png");
        energy = ImageLoader.LoadImage("resources/energy.png");

        map = ImageLoader.LoadImage("resources/map.png");
        enemyTile = ImageLoader.LoadImage("resources/enemy.png");
        treasureTile = ImageLoader.LoadImage("resources/event.png");
        fuelTile = ImageLoader.LoadImage("resources/fuel.png");
        shopTile = ImageLoader.LoadImage("resources/desainshop.png");

//        board2 = ImageLoader.crop("/screen.jpg", 105, 70 ,  394-105,99 );

        BufferedImage boardSet2 = ImageLoader.LoadImage("resources/wood_set_2.png");
        arrowRight = ImageLoader.crop(boardSet2,211,203,177,131);
        arrowDown = ImageLoader.rotateImageByDegrees(arrowRight,90);
        arrowLeft = ImageLoader.rotateImageByDegrees(arrowRight,180);
        arrowUp = ImageLoader.rotateImageByDegrees(arrowRight,-90);

        BufferedImage boardSet = ImageLoader.LoadImage("resources/wooden-planks-set.png");
        plank1 = ImageLoader.crop(boardSet, 111, 11, 214, 44);
        plank2 = ImageLoader.crop(boardSet, 111, 55, 214, 40);
        plank3 = ImageLoader.crop(boardSet, 111, 95, 214, 40);
//        logPress = ImageLoader.crop(btnSheet, 40, 185, 170, 70);
//        board = ImageLoader.crop(btnSheet, 45, (185 + 80), 170, 75);
//        btn1norm = ImageLoader.crop(btnSheet, 400, 270, 145, 350-270);
//        btn1press = ImageLoader.crop(btnSheet, 400, 350, 145, 420-350);
    }
    
}
