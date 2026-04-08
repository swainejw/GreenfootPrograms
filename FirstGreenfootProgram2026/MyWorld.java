import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static Counter scoreC = new Counter();
    public static Counter livesC = new Counter();
    
    public MyWorld()
    {    
        super(600, 400, 1); 
        addObject(new Lobster(), 45, getHeight()/2);
        addObject(new LobsterTrap(), getWidth() - 45, getHeight()/2);
        addObject(new LobsterTrap(), getWidth() - 45, 40);
        addObject(new LobsterTrap(), getWidth() - 45, getHeight() - 40);
        addObject(scoreC, getWidth() - 46, getHeight() - 15);
        addObject(livesC, 46, getHeight() - 15);
        addObject(new Fish(), getWidth(), 50);
        scoreC.setValue(0);
        livesC.setValue(3);
    }
}
