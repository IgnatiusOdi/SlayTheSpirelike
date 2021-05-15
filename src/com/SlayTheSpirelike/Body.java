package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;

public class Body extends JFrame {
    private JPanel panel;
    private int width, height;
    private MouseManager mouse;

    public Body(int width, int height) throws HeadlessException {
        this.width = width;
        this.height = height;
        setSize(width,height);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new MainMenu(this,null);
        add(panel);
        setContentPane(panel);
        setVisible(true);

        mouse = new MouseManager();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addMouseWheelListener(mouse);
    }



    public void setPanel(JPanel panel) {
        this.panel = panel;
        add(panel);
        this.setContentPane(this.panel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public MouseManager getMouse() {
        return mouse;
    }
}
