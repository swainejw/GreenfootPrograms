import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Brick extends Actor
{
    public static int width = 60;
    public static int height = 40;
    
    public Brick()
    {
        getImage().scale(width, height);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public int getWidth()
    {
        return width;
    }
}
