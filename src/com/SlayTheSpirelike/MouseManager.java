package com.SlayTheSpirelike;

import java.awt.event.*;

public class MouseManager implements MouseListener,MouseMotionListener,MouseWheelListener{

    private int x,y;
    private boolean clicked = false;
    private int wheelMove;
    private boolean pressed = false;
    @Override
    public void mouseClicked(MouseEvent me) {
        clicked = true;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        x = me.getX();
        y = me.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        wheelMove = mwe.getWheelRotation();
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getWheelMove() {
        return wheelMove;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public void setWheelMove(int wheelMove) {
        this.wheelMove = wheelMove;
    }

    public boolean isPressed() {
        return pressed;
    }
    
}
