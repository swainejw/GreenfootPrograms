import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Baby extends Actor
{
    boolean moveNow = false;
    SimpleTimer t = new SimpleTimer();
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space") && t.millisElapsed() > 200)
        {
            if (!moveNow)
            {
                //moveNow = true; 
                MyWorld.la.setValue("go");
            }
            else
            {
                //moveNow = false;
                MyWorld.la.setValue("stop");
            }
            
            moveNow = !moveNow; 
            t.mark();
        }
        
        if (moveNow)
        {
            setLocation(getX() + 1, getY());
        }
    }
}
