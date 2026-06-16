import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    SimpleTimer t = new SimpleTimer();
    Label lbl = new Label("START",100);
    int c = 300;
    int timeVal = 1000;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(lbl, getWidth()/2, getHeight()/2);
        
    }
    
    public void act()
    {
        if (t.millisElapsed() >= timeVal)
        {
            c--;
            lbl.setValue(c);
            t.mark();
            timeVal -= 25;
        }
    }
    
}
