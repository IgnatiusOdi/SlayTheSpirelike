package com.SlayTheSpirelike;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.*;

public class ImageLoader {
    public static BufferedImage LoadImage(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        }catch(IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
        return null;
    }
    
    public static BufferedImage crop(BufferedImage img,int x,int y,int width,int height) {
        return img.getSubimage(x, y, width, height);
    }
    public static BufferedImage crop(String path,int x,int y,int width,int height) {
        BufferedImage img = ImageLoader.LoadImage(path);
        return img.getSubimage(x, y, width, height);
    }
}
