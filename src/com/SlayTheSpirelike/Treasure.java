package com.SlayTheSpirelike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Treasure extends JPanel {

    private Body body;

    //BUTTON
    private final int width = 250;
    private final int height = 250;
    private final int space = 250;

    //IMAGE

    //LAYOUT
    private JLabel title;
    private JLabel treasurechest;
    private JLabel guide;
    private JLabel card1;
    private JLabel card2;
    private JLabel card3;
    private JLabel skip;

    public Treasure(Body body) {
        this.body = body;
        init();
    }

    private void init() {
        setLayout(null);
        setSize(1162, 648);
        setBackground(new Color(2, 7, 93));
        setOpaque(true);
        setVisible(true);

        //INIT
        title = new JLabel("TREASURE");
        skip = new JLabel("SKIP");

        //TITLE
        title.setBounds(this.getWidth()/2, 50, 200, 50);
        title.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.yellow);
        title.setBackground(Color.darkGray);
        title.setOpaque(true);
        add(title);

        //SKIP
        skip.setBounds(this.getWidth()/2 - 50, this.getHeight()/2 - 25, 100, 50);
        skip.setFont(new Font("Monospace", Font.BOLD + Font.ITALIC, 30));
        skip.setHorizontalAlignment(SwingConstants.CENTER);
        skip.setVerticalAlignment(SwingConstants.CENTER);
        skip.setForeground(Color.white);
        skip.setBackground(Color.black);
        skip.setOpaque(true);
        skip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "The chance doesn't come twice. Are you sure?", "EXIT", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    body.dispose();
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                skip.setBorder(BorderFactory.createLineBorder(Color.black,1));
                skip.setLocation(skip.getX() + 3, skip.getY() - 3);
                skip.setForeground(Color.black);
                skip.setBackground(Color.white);
                skip.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                skip.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                skip.setLocation(skip.getX() - 3, skip.getY() + 3);
                skip.setForeground(Color.white);
                skip.setBackground(Color.black);
            }
        });
        add(skip);

    }
}
