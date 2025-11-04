import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WinWorld extends World
{

    /**
     * Constructor for objects of class WinWorld.
     * 
     */
    public WinWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(new CRWinner(), getWidth()/2, getHeight()/2);
    }
}
