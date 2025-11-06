import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    SimpleTimer logTimer = new SimpleTimer();
    SimpleTimer logTimer2 = new SimpleTimer();
    int rNum = 1000 + Greenfoot.getRandomNumber(3500);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        addObject(new Frogger(), getWidth()/2, getHeight() - 40);
        logTimer.mark();
        logTimer2.mark();
        setPaintOrder(Frogger.class, Log.class);
    }
    
    public void act()
    {
        if (logTimer.millisElapsed() > 2000)
        {
            addObject(new Log(-3), 800, 160);
            logTimer.mark();
        }
        
        if (logTimer2.millisElapsed() > rNum)
        {
            addObject(new Log(3), 0, 240);
            logTimer2.mark();
            rNum = 1000 + Greenfoot.getRandomNumber(3500);
        }
    }
}
