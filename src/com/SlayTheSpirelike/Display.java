package com.SlayTheSpirelike;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
    private JFrame frame;
    private Canvas canvas;
    private int widht,height;
    
    public Display(int widht,int height) {
        this.widht = widht;
        this.height = height;
        frame = new JFrame();
        canvas = new Canvas();
        init();
    }
    
    private void init()
    {
        frame.setSize(widht, height);
        frame.setTitle("Shop Logic Sinlui Hot 2019");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        
        canvas.setSize(widht, height);
        canvas.setMaximumSize(new Dimension(widht, height));
        canvas.setMinimumSize(new Dimension(widht, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public int getWidht() {
        return widht;
    }

    public int getHeight() {
        return height;
    }
    
}
