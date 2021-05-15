package com.SlayTheSpirelike;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {
    public static BufferedImage mainMenuBackground_old,boardSet;
    public static BufferedImage tanker,warship,carrier;
    public static BufferedImage board, plank1,plank2;

    public static ImageIcon mainMenuBG;
    
    static {
        mainMenuBG = new ImageIcon("resources/mainMenu.png");
        mainMenuBackground_old = ImageLoader.LoadImage("resources/mainMenu.png");
        tanker = ImageLoader.LoadImage("resources/tanker.png");
        warship = ImageLoader.LoadImage("resources/warship.png");
        carrier = ImageLoader.LoadImage("resources/aircraft.png");


//        board2 = ImageLoader.crop("/screen.jpg", 105, 70 ,  394-105,99 );

        BufferedImage boardSet = ImageLoader.LoadImage("resources/wooden-planks-set.png");
        plank1 = ImageLoader.crop(boardSet, 111, 11, 214, 44);
        plank2 = ImageLoader.crop(boardSet, 111, 55, 214, 40);
//        logPress = ImageLoader.crop(btnSheet, 40, 185, 170, 70);
//        board = ImageLoader.crop(btnSheet, 45, (185 + 80), 170, 75);
//        btn1norm = ImageLoader.crop(btnSheet, 400, 270, 145, 350-270);
//        btn1press = ImageLoader.crop(btnSheet, 400, 350, 145, 420-350);
    }
    
}
