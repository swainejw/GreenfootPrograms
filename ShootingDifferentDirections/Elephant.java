import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor
{
    int eleDirection = 0;
    
    public void act() 
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 5, getY());
            eleDirection = 1;
            
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 5, getY());
            eleDirection = 2;
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 5);
            eleDirection = 3;
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 5);
            eleDirection = 4;
        }
        if (Greenfoot.isKeyDown("space"))
        {
            getWorld().addObject(new Peanut(eleDirection), getX(), getY());
        }
    }    
}
