import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LoseWorld extends World
{
    /**
     * Constructor for objects of class LoseWorld.
     * 
     */
    public LoseWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new CRLoser(), 300, 200);
    }
}
