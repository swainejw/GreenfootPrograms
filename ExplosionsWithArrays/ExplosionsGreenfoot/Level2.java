import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    int h1 = 50;
    
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(new Bomb(), 450, h1);
        addObject(new Bomb(), 350, h1);
        addObject(new Bomb(), 250, h1);
        addObject(new Bomb(), 150, h1);
        addObject(new Bomb(), 50, h1);
        
        addObject(new Bomb(), 450, h1 + 70);
        addObject(new Bomb(), 350, h1 + 70);
        addObject(new Bomb(), 250, h1 + 70);
        addObject(new Bomb(), 150, h1 + 70);
        addObject(new Bomb(), 50, h1 + 70);
        
        addObject(new Hero(), getWidth()/2, getHeight() - 50);  
        
        addObject(Globals.score, 30, 10);    
    }
}
