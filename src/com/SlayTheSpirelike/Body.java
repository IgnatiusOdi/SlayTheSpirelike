package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;

public class Body extends JFrame {
    private JPanel panel;
    private MouseManager mouse;
    private KeyboardManager keyboard;

    public Body(int width, int height) throws HeadlessException {
        setSize(width,height);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new MainMenu(this);
        add(panel);
        setContentPane(panel);
        setVisible(true);

        mouse = new MouseManager();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addMouseWheelListener(mouse);

        keyboard = new KeyboardManager();
        addKeyListener(keyboard);
    }



    public void setPanel(JPanel panel) {
        this.panel = panel;
//        add(panel);
        this.setContentPane(this.panel);
    }

    public JPanel getPanel() {
        return panel;
    }

    public MouseManager getMouse() {
        return mouse;
    }

    public KeyboardManager getKeyboard() {
        return keyboard;
    }
}
