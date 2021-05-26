package com.SlayTheSpirelike;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class ImageLoader {
    public static BufferedImage LoadImage(String path) {
        try {
            return ImageIO.read(new File(path));
//            return ImageIO.read(ImageLoader.class.getResource(path));
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

    public static BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {

        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return rotated;
    }
}
