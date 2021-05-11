package com.SlayTheSpirelike;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {
    public static BufferedImage mainMenuBackground,boardSet;
    public static BufferedImage returnBtn,screen;
    public static BufferedImage board,plank1,logPress;
    public static BufferedImage right,left;
    public static BufferedImage btn1press,btn1norm;
    public static BufferedImage logo;
    
    public static void init() {
        mainMenuBackground = ImageLoader.LoadImage("resources/mainMenu.png");
//        right = ImageLoader.LoadImage("/right.png");
//        left = ImageLoader.LoadImage("/left.png");
//        returnBtn = ImageLoader.LoadImage("/return.png");
//        logo = ImageLoader.LoadImage("/logo.png");
//
//        board2 = ImageLoader.crop("/screen.jpg", 105, 70 ,  394-105,99 );
//
        BufferedImage boardSet = ImageLoader.LoadImage("resources/wooden-planks-set.png");
        plank1 = ImageLoader.crop(boardSet, 111, 11, 214, 44);
//        logPress = ImageLoader.crop(btnSheet, 40, 185, 170, 70);
//        board = ImageLoader.crop(btnSheet, 45, (185 + 80), 170, 75);
//        btn1norm = ImageLoader.crop(btnSheet, 400, 270, 145, 350-270);
//        btn1press = ImageLoader.crop(btnSheet, 400, 350, 145, 420-350);
    }
    
}
