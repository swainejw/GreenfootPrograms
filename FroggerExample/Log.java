import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Log extends Actor
{
    int logMoveVal;

    public Log(int l)
    {
        logMoveVal = l;
    }
    
    public void act()
    {
        setLocation(getX() + logMoveVal, getY());
        
        if (getX() > 820 || getX() < -10)
        {
            getWorld().removeObject(this);
        }
        
    }
}
