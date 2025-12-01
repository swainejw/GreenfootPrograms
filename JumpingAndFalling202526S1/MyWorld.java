import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static Mario mar = new Mario();
    int brickWidth = 60;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(mar, getWidth()/2, getHeight() - 60);
        
        for (int x = 0; x < 15; x++)
        {
            addObject(new Brick(), x*brickWidth, 380);

        }
        
        for (int x = 0; x < 4; x++)
        {
            addObject(new Brick(), x*brickWidth, 340);
        }
    
        for (int x = 7; x < 11; x++)
        {
            addObject(new Brick(), x*brickWidth, 340);
        }
    }
}
