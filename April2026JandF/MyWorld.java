import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static Steve stv = new Steve();
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(stv, 40, getHeight() - 50);
        
        // Make a row of bricks (like a platform) at y-coord 30 above the bottom)
        // offset = 25, spacing =  50
        for (int x = 0; x < 15; x++)
        {
            addObject(new Brick(), 25 + x*50, getHeight() - 10);
        }
        
        for (int x = 0; x < 8; x++)
        {
            addObject(new Brick(), 25 + x*50, getHeight() - 150);
        }
        
        for (int x = 4; x < 15; x++)
        {
            addObject(new Brick(), 25 + x*50, getHeight() - 250);
        }
    }
}
