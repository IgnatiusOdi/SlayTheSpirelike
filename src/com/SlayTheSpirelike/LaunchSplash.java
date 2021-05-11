package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LaunchSplash extends JFrame {
    //VARIABLE DECLARATION
    private JPanel panel;
    private JLabel label1;
    private JLabel label2;
    private JProgressBar bar;

    public LaunchSplash() {
        initComponents();
        setVisible(true);
        runProgressBar();
    }

    private Font loadFont(String path) {
        Font font;
        if (path == null) {
            return new Font("serif", Font.PLAIN, 24);
        }

        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(path)));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        font = new Font("Signatria",Font.PLAIN,150);
        return font;
    }

    private void runProgressBar() {
        for (int i = 0; i <= 100; i++) {
            label2.setLocation( (int) (bar.getWidth()*1.0/100*i)-label2.getWidth()-1, bar.getY()-bar.getHeight()+6);
            bar.setValue(i);
            bar.setForeground(new Color(0, 152+i, 255));
            try{
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dispose();
    }

    private void initComponents() {
        //FRAME
        setSize(new Dimension(400,300));
        setLocationRelativeTo(null);
        setUndecorated(true);
        setBackground(new Color(0,152,255));

        //INIT
        panel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        bar = new JProgressBar();

        //PANEL
        panel.setLayout(null);
        panel.setSize(400,300);
        panel.setOpaque(false);

        //LABEL
        label1.setBounds(35,55,340,135);
        label1.setForeground(new Color(255,255,0));
        label1.setFont(loadFont("src/Splash/Signatria.ttf"));
        label1.setText("Loading");
        panel.add(label1);

        //IMAGE
        label2.setIcon(new ImageIcon("src/Splash/sailingboat.gif"));
        label2.setBounds(0,100,50,50);
        panel.add(label2);

        bar.setStringPainted(true);
        bar.setBounds(0,255,400,45);
        bar.setForeground(new Color(107,252,255));
        bar.setBackground(new Color(0,152,255));
        bar.setStringPainted(false);
        bar.setBorderPainted(false);
        bar.setOpaque(true);
        panel.add(bar);

        add(panel);
        setContentPane(panel);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2,2,2,2, new Color(107,252,255)));
    }
}
