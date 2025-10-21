import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new WriteOut(), getWidth()/2 - 50, getHeight()/2);
        addObject(new ReadIn(), getWidth()/2 + 50, getHeight()/2);
    }
}
