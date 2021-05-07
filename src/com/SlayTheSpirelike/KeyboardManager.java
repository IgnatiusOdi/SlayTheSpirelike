/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SlayTheSpirelike;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author CBEngineer
 */
public class KeyboardManager implements KeyListener{
    int key;
    String input;
    boolean keyTyped, backSpace;

    public KeyboardManager() {
        input = "";
        keyTyped = false;
        backSpace = false;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        key = ke.getKeyChar();
        if (key == KeyEvent.VK_0){
            input = "0";
        }
        if (key == KeyEvent.VK_1){
            input = "1";
        }
        if (key == KeyEvent.VK_2){
            input = "2";
        }
        if (key == KeyEvent.VK_3){
            input = "3";
        }
        if (key == KeyEvent.VK_4){
            input = "4";
        }
        if (key == KeyEvent.VK_5){
            input = "5";
        }
        if (key == KeyEvent.VK_6){
            input = "6";
        }
        if (key == KeyEvent.VK_7){
            input = "7";
        }
        if (key == KeyEvent.VK_8){
            input = "8";
        }
        if (key == KeyEvent.VK_9){
            input = "9";
        }
        if (key == KeyEvent.VK_BACK_SPACE){
            backSpace = true;
        }
        keyTyped = true;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
    public String getInput(){
        return input;
    }
    
    public void setDefaultInput(){
        input = "";
    }
    
    public boolean getKeyTyped(){
        return keyTyped;
    }
    
    public void setKeyTypedFalse(){
        this.keyTyped = false;
    }
    
    public boolean getBackSpace(){
        return backSpace;
    }
    
    public void setBackSpaceFalse(){
        backSpace = false;
    }
}

