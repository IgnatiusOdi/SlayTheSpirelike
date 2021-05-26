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
    int keyCode;
    char key;
    String input;
    StringBuilder stringBuffer;
    boolean keyTyped, backSpace;

    public KeyboardManager() {
        stringBuffer = new StringBuilder();
        input = "";
        keyTyped = false;
        backSpace = false;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
//        keyCode = ke.getKeyChar();
        key = ke.getKeyChar();
        stringBuffer.append(ke.getKeyChar());
//        System.out.println(stringBuffer);
/*        if (keyCode == KeyEvent.VK_0){
            input = "0";
        }
        if (keyCode == KeyEvent.VK_1){
            input = "1";
        }
        if (keyCode == KeyEvent.VK_2){
            input = "2";
        }
        if (keyCode == KeyEvent.VK_3){
            input = "3";
        }
        if (keyCode == KeyEvent.VK_4){
            input = "4";
        }
        if (keyCode == KeyEvent.VK_5){
            input = "5";
        }
        if (keyCode == KeyEvent.VK_6){
            input = "6";
        }
        if (keyCode == KeyEvent.VK_7){
            input = "7";
        }
        if (keyCode == KeyEvent.VK_8){
            input = "8";
        }
        if (keyCode == KeyEvent.VK_9){
            input = "9";
        }*/
        if (stringBuffer.toString().equals("iddqd")) {
            System.out.println("invincibility??");
        }
        if (key == KeyEvent.VK_ENTER) {
            stringBuffer = new StringBuilder();
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

