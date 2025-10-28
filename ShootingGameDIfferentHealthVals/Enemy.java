import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int value = 10;
    public static int health = 5; 
    
    public Enemy()
    {
        health = 5;
    }
    
    public void act() 
    {
        if (health == 0)
        {
            getWorld().removeObject(this);
        }
        
    }    
    
    public int getValue()
    {
        return value;
    }
    
}
