import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static Mario mar = new Mario();
    int numBricks = 15;
    int brickWidth = 60;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(mar, getWidth()/2, getHeight() - 60);
        for (int x = 0; x < numBricks; x++)
        {
            addObject(new Brick(), x*brickWidth, 380);

        }
    }
}
