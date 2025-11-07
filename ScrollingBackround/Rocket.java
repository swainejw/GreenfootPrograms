import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    public Rocket()
    {
        turn(270);
    }
    public void act() 
    {
        // movement related to key downs
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 4, getY());
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 4, getY());
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 4);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 4);
        }
        
        
    }    
}
