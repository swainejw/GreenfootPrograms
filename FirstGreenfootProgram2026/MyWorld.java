import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public MyWorld()
    {    
        super(600, 400, 1); 
        addObject(new Lobster(), 45, getHeight()/2);
        addObject(new LobsterTrap(), getWidth() - 45, getHeight()/2);
    }
}
