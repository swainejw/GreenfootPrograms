import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Rock extends Actor
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private SimpleTimer t = new SimpleTimer();
    boolean blnGo = false;
    int xVal, yVal;
    final int TIME_LIMIT = 1500;
    final int XMOVE = 2;
    final int YMOVE = 2;
        
    public void act() 
    {
        if (Greenfoot.isKeyDown("left"))
        {
            t.mark();
            blnGo = true;
            xVal = -XMOVE;
            yVal = 0;
        }
        if (Greenfoot.isKeyDown("right"))
        {
            t.mark();
            blnGo = true;
            xVal = XMOVE;
            yVal = 0;
        }
        if (Greenfoot.isKeyDown("up"))
        {
            t.mark();
            blnGo = true;
            yVal = -YMOVE;
            xVal = 0;
        }
        if (Greenfoot.isKeyDown("down"))
        {
            t.mark();
            blnGo = true;
            yVal = YMOVE;
            xVal = 0;
        }
        
        if (t.millisElapsed() < TIME_LIMIT && blnGo == true)
        {
            setLocation(getX() + xVal, getY() + yVal);
        }

    }    
    
}
