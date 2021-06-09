package com.SlayTheSpirelike.notused;

import com.SlayTheSpirelike.Assets;
import com.SlayTheSpirelike.MouseManager;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Body_old implements Runnable{

    private Thread thread ;
    private Display display;
    private Graphics g;
    private BufferStrategy bs;
    private boolean running;

    private MouseManager mouse;

    private MainMenu_old mainMenu;
    
    public Body_old(int widht, int height) {
        display = new Display(widht, height);
        thread = new Thread(this);
        running = true;
        init();
        thread.start();
    }
    
    private void init()
    {
        mouse = new MouseManager();
        display.getCanvas().addMouseListener(mouse);
        display.getCanvas().addMouseMotionListener(mouse);
        display.getCanvas().addMouseWheelListener(mouse);
        
        display.getFrame().addMouseListener(mouse);
        display.getFrame().addMouseMotionListener(mouse);
        display.getFrame().addMouseWheelListener(mouse);
        
//        Assets.init();
        mainMenu = new MainMenu_old(this);

        State.setCurrent(mainMenu);
    }
    
    @Override
    public void run() {
        //int fps = 120;
        //long now = 0;
        //long delta = 0;
        //long last = System.nanoTime();
        
        while (running) {            
            tick();
            render();
        }
        
        /*while(running)
        {
            now = System.nanoTime();
            delta += now - last;
            last = now;
            if(delta  >=  (1000000000 / fps))
            {delta = 0;
                tick();
                render();
            }
        }*/
       
    }
    private void render()
    {
        if(display.getCanvas().getBufferStrategy() == null)
                display.getCanvas().createBufferStrategy(3);
            bs = display.getCanvas().getBufferStrategy();
            g = bs.getDrawGraphics();
            
            g.clearRect(0, 0, display.getWidht(), display.getHeight());
            
            State.getCurrent().render(g);
            
            bs.show();
            g.dispose();
    }
    private void tick()
    {
        State.getCurrent().tick();
        /*try {
            Database.rs = Database.stmt.executeQuery("Select * from playerdata");
            while(database.rs.next())
            {
                System.out.println("ID :" + Database.rs.getInt("id"));
            }
        }catch(Exception e)
        {
            
        }
        */
    }
    public int getWidht() {
        return display.getWidht();
    }
    public int getHeight() {
        return display.getHeight();
    }

    public MouseManager getMouse() {
        return mouse;
    }

    public MainMenu_old getMainMenu() {
        return mainMenu;
    }

    public Display getDisplay() {
        return display;
    }

}
