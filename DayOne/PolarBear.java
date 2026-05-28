import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PolarBear extends Actor
{
    public void act()
    {
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 3);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 3);
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 3, getY());
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 3, getY());
        }
        
        if (Greenfoot.isKeyDown("space"))
        {
            getWorld().addObject(new Fish(), getX(), getY());
        }
    }
}
