import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(new Bomb(), 450, 50);
        addObject(new Bomb(), 350, 50);
        addObject(new Bomb(), 250, 50);
        addObject(new Bomb(), 150, 50);
        addObject(new Bomb(), 50, 50);
        
        addObject(new Hero(), getWidth()/2, getHeight() - 50);  
        
        addObject(Globals.score, 30, 10);    
        Globals.score.setValue(0);
    }
}
