import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Peanut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Peanut extends Actor
{
    public int pDirection = 0;
    
    public Peanut(int d)
    {
        pDirection = d;
        
    }
    
    public void act() 
    {
        if (pDirection == 1)
        {
            setLocation(getX() + 10, getY());
        }
        if (pDirection == 2)
        {
            setLocation(getX() - 10, getY());
        }
        if (pDirection == 3)
        {
            setLocation(getX() , getY() - 10);
        }
        if (pDirection == 4)
        {
            setLocation(getX() , getY() + 10);
        }
        
        
        if ((getX() > 590) || (getX() < 10) || (getY() < 10) || (getY() > 390))
        {
            getWorld().removeObject(this);
        }
    }    
}
