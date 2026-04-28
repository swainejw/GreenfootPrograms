import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static Steve stv = new Steve();
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(stv, getWidth()/2, getHeight() - 150);
        addObject(new Brick(), getWidth()/2, getHeight() - 30);
        
    }
}
