package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage     mainMenuBackground_old, battle1BG, battle2BG, woodenBG, board,
                                    tanker,warship,carrier, helicopter,
                                    plank1,plank2,plank3,
                                    map, enemyTile, treasureTile, fuelTile, shopTile,
                                    arrowRight, arrowDown, arrowLeft, arrowUp,
                                    fuelTank,coin,heart,energy,deck,shield,
                                    boss1, boss2;

    public static ImageIcon mainMenuBG;
    
    static {
        mainMenuBG = new ImageIcon("resources/mainMenu.png");
        mainMenuBackground_old = ImageLoader.LoadImage("resources/mainMenu.png");
        battle1BG = ImageLoader.LoadImage("resources/battle1.png");
        battle2BG = ImageLoader.LoadImage("resources/battle2.png");
        woodenBG = ImageLoader.LoadImage("resources/woodbg.jpg");
        board = ImageLoader.LoadImage("resources/hangingsign.png");

        tanker = ImageLoader.LoadImage("resources/tanker.png");
        warship = ImageLoader.LoadImage("resources/warship.png");
        carrier = ImageLoader.LoadImage("resources/aircraft.png");
        helicopter = ImageLoader.LoadImage("resources/summonPotion.png");

        fuelTank = ImageLoader.LoadImage("resources/tank.png");
        coin = ImageLoader.LoadImage("resources/coin.png");
        heart = ImageLoader.LoadImage("resources/health.png");
        energy = ImageLoader.LoadImage("resources/energy.png");
        deck = ImageLoader.LoadImage("resources/cardBack.png");
        shield = ImageLoader.LoadImage("resources/shield.png");

        map = ImageLoader.LoadImage("resources/map.png");
        enemyTile = ImageLoader.LoadImage("resources/enemy.png");
        treasureTile = ImageLoader.LoadImage("resources/event.png");
        fuelTile = ImageLoader.LoadImage("resources/fuel.png");
        shopTile = ImageLoader.LoadImage("resources/desainshop.png");
        boss1 = ImageLoader.LoadImage("resources/Kingdestroyer.png");
        boss2 = ImageLoader.LoadImage("resources/earthshaker.png");

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
    }
    
}
