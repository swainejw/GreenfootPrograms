import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Burger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Burger extends Actor
{
    int w = 400;
    int h = 350;
    
    public Burger()
    {
        getImage().scale(w,h);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            w *= .19;
            h *= .19;
            getImage().scale(w,h);
        }
    }
}
