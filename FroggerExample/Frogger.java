import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Frogger extends Actor
{
    SimpleTimer moveTimer = new SimpleTimer();
    int moveAmt = 40;
    int timeDelay = 250;
    int dir = -1;
    
    public void act()
    {
        if (moveTimer.millisElapsed() > timeDelay)
        {
            if (Greenfoot.isKeyDown("left"))
            {
                if (dir == 1)
                {
                    getImage().mirrorHorizontally();
                }
                dir = 0;
                setLocation(getX() - moveAmt, getY());
            }
            else if (Greenfoot.isKeyDown("right"))
            {
                
                if (dir == 0)
                {
                    getImage().mirrorHorizontally();
                }
                dir = 1;
                setLocation(getX() + moveAmt, getY());
            }
            else if (Greenfoot.isKeyDown("up"))
            {
                setLocation(getX(), getY() - moveAmt);
            }
            else if (Greenfoot.isKeyDown("down"))
            {
                setLocation(getX(), getY() + moveAmt);
            }
            moveTimer.mark();
        }
        
        Log lo = (Log) getOneIntersectingObject(Log.class);
        if (lo != null)
        {
            setLocation(getX() + lo.logMoveVal, getY());
        }
        
        
    }
    
   
}
